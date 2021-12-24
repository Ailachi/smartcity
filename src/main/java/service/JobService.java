package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import database.Place;
import database.Vacancy;
import repository.JobRepository;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.*;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class JobService {

    @Resource
    private ConnectionFactory connectionFactory;

    @Resource(name="vacancyQueue")
    private Queue vacancyQueue;



    @EJB
    private JobRepository repo;

    public List<Vacancy> getAllVacancies() {
        return repo.getAllVacancies();
    }

    public List<Vacancy> getVacanciesFilteredByYear(int year) {
        List<Vacancy> vacancies = repo.getAllVacancies();
        vacancies = vacancies.stream()
                .filter(v->v.getPostDate().getYear() > year).collect(Collectors.toList());
        return vacancies;
    }

    public String sendVacancyJms(Vacancy vacancy) {
        try (final Connection connection = connectionFactory.createConnection();
             final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
             final MessageProducer producer = session.createProducer(vacancyQueue)) {
            connection.start();
            ObjectMapper om = new ObjectMapper();
            String jsonUser = om.writeValueAsString(vacancy);

            final Message jmsMessage = session.createTextMessage(jsonUser);
            producer.send(jmsMessage);

            return "Successfully sent vacancy!";
        } catch (final Exception e) {
            throw new RuntimeException("Caught exception from JMS when sending a message", e);
        }
    }

    public Vacancy getVacancyJms() {

        try (final Connection connection = connectionFactory.createConnection();
             final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
             final MessageConsumer messageConsumer = session.createConsumer(vacancyQueue)) {

            connection.start();


            final Message jmsMessage = messageConsumer.receive(1000);

            if(jmsMessage == null) {
                return null;
            }

            TextMessage obj = (TextMessage) jmsMessage;
            ObjectMapper om = new ObjectMapper();

            Vacancy vacancy = om.readValue(obj.getText(), Vacancy.class);

            return vacancy;

        } catch (final Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Caught exception from JMS when receiving a message", e);
        }
    }

    public int createVacancy(Vacancy vacancy) {
        return repo.createVacancy(vacancy);
    }
    public int verifyVacancy(Vacancy vacancy) {
        if(!vacancy.getPosition().equals("NoPosition")) {
            return 1;
        }
        return 0;
    }


}

