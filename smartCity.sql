toc.dat                                                                                             0000600 0004000 0002000 00000053425 14161405743 0014455 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP                            y         	   SmartCity    13.0    13.0 M               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                    0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                    0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                    1262    26555 	   SmartCity    DATABASE     h   CREATE DATABASE "SmartCity" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "SmartCity";
                postgres    false         ?            1259    26558    businessnews    TABLE     ?   CREATE TABLE public.businessnews (
    newsid integer NOT NULL,
    heading character varying(255) NOT NULL,
    text character varying(255) NOT NULL,
    authorid integer
);
     DROP TABLE public.businessnews;
       public         heap    postgres    false         ?            1259    26556    businessnews_newsid_seq    SEQUENCE     ?   CREATE SEQUENCE public.businessnews_newsid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.businessnews_newsid_seq;
       public          postgres    false    201                    0    0    businessnews_newsid_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.businessnews_newsid_seq OWNED BY public.businessnews.newsid;
          public          postgres    false    200         ?            1259    26569    place    TABLE     f   CREATE TABLE public.place (
    placeid integer NOT NULL,
    name character varying(255) NOT NULL
);
    DROP TABLE public.place;
       public         heap    postgres    false         ?            1259    26567    place_placeid_seq    SEQUENCE     ?   CREATE SEQUENCE public.place_placeid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.place_placeid_seq;
       public          postgres    false    203                    0    0    place_placeid_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.place_placeid_seq OWNED BY public.place.placeid;
          public          postgres    false    202         ?            1259    26577    role    TABLE     d   CREATE TABLE public.role (
    roleid integer NOT NULL,
    name character varying(255) NOT NULL
);
    DROP TABLE public.role;
       public         heap    postgres    false         ?            1259    26575    role_roleid_seq    SEQUENCE     ?   CREATE SEQUENCE public.role_roleid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.role_roleid_seq;
       public          postgres    false    205                    0    0    role_roleid_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.role_roleid_seq OWNED BY public.role.roleid;
          public          postgres    false    204         ?            1259    26585    sight    TABLE     ?   CREATE TABLE public.sight (
    sightid integer NOT NULL,
    address character varying(255) NOT NULL,
    childrenfree boolean NOT NULL,
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL,
    placeid integer
);
    DROP TABLE public.sight;
       public         heap    postgres    false         ?            1259    26583    sight_sightid_seq    SEQUENCE     ?   CREATE SEQUENCE public.sight_sightid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.sight_sightid_seq;
       public          postgres    false    207                    0    0    sight_sightid_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.sight_sightid_seq OWNED BY public.sight.sightid;
          public          postgres    false    206         ?            1259    26596 	   specialty    TABLE     ?   CREATE TABLE public.specialty (
    specialtyid integer NOT NULL,
    hasscholarship boolean NOT NULL,
    name character varying(255) NOT NULL
);
    DROP TABLE public.specialty;
       public         heap    postgres    false         ?            1259    26594    specialty_specialtyid_seq    SEQUENCE     ?   CREATE SEQUENCE public.specialty_specialtyid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.specialty_specialtyid_seq;
       public          postgres    false    209                    0    0    specialty_specialtyid_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.specialty_specialtyid_seq OWNED BY public.specialty.specialtyid;
          public          postgres    false    208         ?            1259    26602    specialtysubject    TABLE     k   CREATE TABLE public.specialtysubject (
    subjectid integer NOT NULL,
    specialtyid integer NOT NULL
);
 $   DROP TABLE public.specialtysubject;
       public         heap    postgres    false         ?            1259    26607    subject    TABLE     ?   CREATE TABLE public.subject (
    subjectid integer NOT NULL,
    credits integer NOT NULL,
    name character varying(255) NOT NULL
);
    DROP TABLE public.subject;
       public         heap    postgres    false         ?            1259    26605    subject_subjectid_seq    SEQUENCE     ?   CREATE SEQUENCE public.subject_subjectid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.subject_subjectid_seq;
       public          postgres    false    212                    0    0    subject_subjectid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.subject_subjectid_seq OWNED BY public.subject.subjectid;
          public          postgres    false    211         ?            1259    26615 
   university    TABLE       CREATE TABLE public.university (
    universityid integer NOT NULL,
    address character varying(255) NOT NULL,
    avggpa numeric(19,2) NOT NULL,
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL,
    placeid integer,
    specialtyid integer
);
    DROP TABLE public.university;
       public         heap    postgres    false         ?            1259    26613    university_universityid_seq    SEQUENCE     ?   CREATE SEQUENCE public.university_universityid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.university_universityid_seq;
       public          postgres    false    214                    0    0    university_universityid_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.university_universityid_seq OWNED BY public.university.universityid;
          public          postgres    false    213         ?            1259    26626    users    TABLE     ?   CREATE TABLE public.users (
    userid integer NOT NULL,
    email character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    surname character varying(255) NOT NULL,
    roleid integer
);
    DROP TABLE public.users;
       public         heap    postgres    false         ?            1259    26624    users_userid_seq    SEQUENCE     ?   CREATE SEQUENCE public.users_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.users_userid_seq;
       public          postgres    false    216                    0    0    users_userid_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.users_userid_seq OWNED BY public.users.userid;
          public          postgres    false    215         ?            1259    26637    vacancy    TABLE     ?   CREATE TABLE public.vacancy (
    vacancyid integer NOT NULL,
    "position" character varying(255) NOT NULL,
    postdate date NOT NULL,
    salary integer NOT NULL,
    placetype integer
);
    DROP TABLE public.vacancy;
       public         heap    postgres    false         ?            1259    26635    vacancy_vacancyid_seq    SEQUENCE     ?   CREATE SEQUENCE public.vacancy_vacancyid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.vacancy_vacancyid_seq;
       public          postgres    false    218                     0    0    vacancy_vacancyid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.vacancy_vacancyid_seq OWNED BY public.vacancy.vacancyid;
          public          postgres    false    217         Z           2604    26561    businessnews newsid    DEFAULT     z   ALTER TABLE ONLY public.businessnews ALTER COLUMN newsid SET DEFAULT nextval('public.businessnews_newsid_seq'::regclass);
 B   ALTER TABLE public.businessnews ALTER COLUMN newsid DROP DEFAULT;
       public          postgres    false    200    201    201         [           2604    26572    place placeid    DEFAULT     n   ALTER TABLE ONLY public.place ALTER COLUMN placeid SET DEFAULT nextval('public.place_placeid_seq'::regclass);
 <   ALTER TABLE public.place ALTER COLUMN placeid DROP DEFAULT;
       public          postgres    false    203    202    203         \           2604    26580    role roleid    DEFAULT     j   ALTER TABLE ONLY public.role ALTER COLUMN roleid SET DEFAULT nextval('public.role_roleid_seq'::regclass);
 :   ALTER TABLE public.role ALTER COLUMN roleid DROP DEFAULT;
       public          postgres    false    204    205    205         ]           2604    26588    sight sightid    DEFAULT     n   ALTER TABLE ONLY public.sight ALTER COLUMN sightid SET DEFAULT nextval('public.sight_sightid_seq'::regclass);
 <   ALTER TABLE public.sight ALTER COLUMN sightid DROP DEFAULT;
       public          postgres    false    206    207    207         ^           2604    26599    specialty specialtyid    DEFAULT     ~   ALTER TABLE ONLY public.specialty ALTER COLUMN specialtyid SET DEFAULT nextval('public.specialty_specialtyid_seq'::regclass);
 D   ALTER TABLE public.specialty ALTER COLUMN specialtyid DROP DEFAULT;
       public          postgres    false    209    208    209         _           2604    26610    subject subjectid    DEFAULT     v   ALTER TABLE ONLY public.subject ALTER COLUMN subjectid SET DEFAULT nextval('public.subject_subjectid_seq'::regclass);
 @   ALTER TABLE public.subject ALTER COLUMN subjectid DROP DEFAULT;
       public          postgres    false    211    212    212         `           2604    26618    university universityid    DEFAULT     ?   ALTER TABLE ONLY public.university ALTER COLUMN universityid SET DEFAULT nextval('public.university_universityid_seq'::regclass);
 F   ALTER TABLE public.university ALTER COLUMN universityid DROP DEFAULT;
       public          postgres    false    213    214    214         a           2604    26629    users userid    DEFAULT     l   ALTER TABLE ONLY public.users ALTER COLUMN userid SET DEFAULT nextval('public.users_userid_seq'::regclass);
 ;   ALTER TABLE public.users ALTER COLUMN userid DROP DEFAULT;
       public          postgres    false    215    216    216         b           2604    26640    vacancy vacancyid    DEFAULT     v   ALTER TABLE ONLY public.vacancy ALTER COLUMN vacancyid SET DEFAULT nextval('public.vacancy_vacancyid_seq'::regclass);
 @   ALTER TABLE public.vacancy ALTER COLUMN vacancyid DROP DEFAULT;
       public          postgres    false    217    218    218                    0    26558    businessnews 
   TABLE DATA           G   COPY public.businessnews (newsid, heading, text, authorid) FROM stdin;
    public          postgres    false    201       3072.dat           0    26569    place 
   TABLE DATA           .   COPY public.place (placeid, name) FROM stdin;
    public          postgres    false    203       3074.dat           0    26577    role 
   TABLE DATA           ,   COPY public.role (roleid, name) FROM stdin;
    public          postgres    false    205       3076.dat           0    26585    sight 
   TABLE DATA           U   COPY public.sight (sightid, address, childrenfree, name, phone, placeid) FROM stdin;
    public          postgres    false    207       3078.dat           0    26596 	   specialty 
   TABLE DATA           F   COPY public.specialty (specialtyid, hasscholarship, name) FROM stdin;
    public          postgres    false    209       3080.dat 	          0    26602    specialtysubject 
   TABLE DATA           B   COPY public.specialtysubject (subjectid, specialtyid) FROM stdin;
    public          postgres    false    210       3081.dat           0    26607    subject 
   TABLE DATA           ;   COPY public.subject (subjectid, credits, name) FROM stdin;
    public          postgres    false    212       3083.dat           0    26615 
   university 
   TABLE DATA           f   COPY public.university (universityid, address, avggpa, name, phone, placeid, specialtyid) FROM stdin;
    public          postgres    false    214       3085.dat           0    26626    users 
   TABLE DATA           O   COPY public.users (userid, email, name, password, surname, roleid) FROM stdin;
    public          postgres    false    216       3087.dat           0    26637    vacancy 
   TABLE DATA           U   COPY public.vacancy (vacancyid, "position", postdate, salary, placetype) FROM stdin;
    public          postgres    false    218       3089.dat !           0    0    businessnews_newsid_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.businessnews_newsid_seq', 2, true);
          public          postgres    false    200         "           0    0    place_placeid_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.place_placeid_seq', 3, true);
          public          postgres    false    202         #           0    0    role_roleid_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.role_roleid_seq', 5, true);
          public          postgres    false    204         $           0    0    sight_sightid_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.sight_sightid_seq', 2, true);
          public          postgres    false    206         %           0    0    specialty_specialtyid_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.specialty_specialtyid_seq', 4, true);
          public          postgres    false    208         &           0    0    subject_subjectid_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.subject_subjectid_seq', 4, true);
          public          postgres    false    211         '           0    0    university_universityid_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.university_universityid_seq', 3, true);
          public          postgres    false    213         (           0    0    users_userid_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.users_userid_seq', 6, true);
          public          postgres    false    215         )           0    0    vacancy_vacancyid_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.vacancy_vacancyid_seq', 5, true);
          public          postgres    false    217         d           2606    26566    businessnews businessnews_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.businessnews
    ADD CONSTRAINT businessnews_pkey PRIMARY KEY (newsid);
 H   ALTER TABLE ONLY public.businessnews DROP CONSTRAINT businessnews_pkey;
       public            postgres    false    201         f           2606    26574    place place_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.place
    ADD CONSTRAINT place_pkey PRIMARY KEY (placeid);
 :   ALTER TABLE ONLY public.place DROP CONSTRAINT place_pkey;
       public            postgres    false    203         h           2606    26582    role role_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (roleid);
 8   ALTER TABLE ONLY public.role DROP CONSTRAINT role_pkey;
       public            postgres    false    205         j           2606    26593    sight sight_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.sight
    ADD CONSTRAINT sight_pkey PRIMARY KEY (sightid);
 :   ALTER TABLE ONLY public.sight DROP CONSTRAINT sight_pkey;
       public            postgres    false    207         l           2606    26601    specialty specialty_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.specialty
    ADD CONSTRAINT specialty_pkey PRIMARY KEY (specialtyid);
 B   ALTER TABLE ONLY public.specialty DROP CONSTRAINT specialty_pkey;
       public            postgres    false    209         n           2606    26612    subject subject_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.subject
    ADD CONSTRAINT subject_pkey PRIMARY KEY (subjectid);
 >   ALTER TABLE ONLY public.subject DROP CONSTRAINT subject_pkey;
       public            postgres    false    212         p           2606    26623    university university_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.university
    ADD CONSTRAINT university_pkey PRIMARY KEY (universityid);
 D   ALTER TABLE ONLY public.university DROP CONSTRAINT university_pkey;
       public            postgres    false    214         r           2606    26634    users users_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (userid);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    216         t           2606    26642    vacancy vacancy_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.vacancy
    ADD CONSTRAINT vacancy_pkey PRIMARY KEY (vacancyid);
 >   ALTER TABLE ONLY public.vacancy DROP CONSTRAINT vacancy_pkey;
       public            postgres    false    218         y           2606    26663 &   university fk4opp7nwqy8y0mm9n1j5su49xt    FK CONSTRAINT     ?   ALTER TABLE ONLY public.university
    ADD CONSTRAINT fk4opp7nwqy8y0mm9n1j5su49xt FOREIGN KEY (placeid) REFERENCES public.place(placeid);
 P   ALTER TABLE ONLY public.university DROP CONSTRAINT fk4opp7nwqy8y0mm9n1j5su49xt;
       public          postgres    false    214    2918    203         {           2606    26673 !   users fk5ogtm7b0y9isqbrtf2g9xjddy    FK CONSTRAINT     ?   ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk5ogtm7b0y9isqbrtf2g9xjddy FOREIGN KEY (roleid) REFERENCES public.role(roleid);
 K   ALTER TABLE ONLY public.users DROP CONSTRAINT fk5ogtm7b0y9isqbrtf2g9xjddy;
       public          postgres    false    205    2920    216         |           2606    26678 #   vacancy fk8t5iy5ec6j4q5g26pjgkxf0yi    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vacancy
    ADD CONSTRAINT fk8t5iy5ec6j4q5g26pjgkxf0yi FOREIGN KEY (placetype) REFERENCES public.place(placeid);
 M   ALTER TABLE ONLY public.vacancy DROP CONSTRAINT fk8t5iy5ec6j4q5g26pjgkxf0yi;
       public          postgres    false    203    218    2918         x           2606    26658 +   specialtysubject fk8whq0riwj9b97443gk30y6wc    FK CONSTRAINT     ?   ALTER TABLE ONLY public.specialtysubject
    ADD CONSTRAINT fk8whq0riwj9b97443gk30y6wc FOREIGN KEY (subjectid) REFERENCES public.subject(subjectid);
 U   ALTER TABLE ONLY public.specialtysubject DROP CONSTRAINT fk8whq0riwj9b97443gk30y6wc;
       public          postgres    false    210    2926    212         v           2606    26648 !   sight fkjj6o810min8l69bqrlevwyiev    FK CONSTRAINT     ?   ALTER TABLE ONLY public.sight
    ADD CONSTRAINT fkjj6o810min8l69bqrlevwyiev FOREIGN KEY (placeid) REFERENCES public.place(placeid);
 K   ALTER TABLE ONLY public.sight DROP CONSTRAINT fkjj6o810min8l69bqrlevwyiev;
       public          postgres    false    207    2918    203         w           2606    26653 ,   specialtysubject fkmv46gcu65mfysfff4vyf9h7am    FK CONSTRAINT     ?   ALTER TABLE ONLY public.specialtysubject
    ADD CONSTRAINT fkmv46gcu65mfysfff4vyf9h7am FOREIGN KEY (specialtyid) REFERENCES public.specialty(specialtyid);
 V   ALTER TABLE ONLY public.specialtysubject DROP CONSTRAINT fkmv46gcu65mfysfff4vyf9h7am;
       public          postgres    false    209    2924    210         u           2606    26643 (   businessnews fknxytorp73ypeu5lfxt1uhs7rd    FK CONSTRAINT     ?   ALTER TABLE ONLY public.businessnews
    ADD CONSTRAINT fknxytorp73ypeu5lfxt1uhs7rd FOREIGN KEY (authorid) REFERENCES public.users(userid);
 R   ALTER TABLE ONLY public.businessnews DROP CONSTRAINT fknxytorp73ypeu5lfxt1uhs7rd;
       public          postgres    false    2930    201    216         z           2606    26668 &   university fkop50xcb8u3kvdg4na51e8o12n    FK CONSTRAINT     ?   ALTER TABLE ONLY public.university
    ADD CONSTRAINT fkop50xcb8u3kvdg4na51e8o12n FOREIGN KEY (specialtyid) REFERENCES public.specialty(specialtyid);
 P   ALTER TABLE ONLY public.university DROP CONSTRAINT fkop50xcb8u3kvdg4na51e8o12n;
       public          postgres    false    2924    209    214                                                                                                                                                                                                                                                   3072.dat                                                                                            0000600 0004000 0002000 00000000176 14161405743 0014256 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Stocks	Todays stock is good. Yesterday it was not good	4
2	Book	It is very important to read books, guys. So, do it.	6
\.


                                                                                                                                                                                                                                                                                                                                                                                                  3074.dat                                                                                            0000600 0004000 0002000 00000000071 14161405743 0014252 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	IITU main building
2	Baizak Center
3	Dostyk Plaza
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                       3076.dat                                                                                            0000600 0004000 0002000 00000000076 14161405743 0014261 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	ADMIN
2	STUDENT
3	TOURIST
4	BUSINESSPERSON
5	JOBSEEKER
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                  3078.dat                                                                                            0000600 0004000 0002000 00000000120 14161405743 0014251 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Big Ben St.	f	Big Ben	2222	3
2	Avenue St.	t	Empire State building	1223	2
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                3080.dat                                                                                            0000600 0004000 0002000 00000000100 14161405743 0014240 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	t	Software Engineer
2	f	IS
3	t	CSSE
4	f	Computer Science
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                3081.dat                                                                                            0000600 0004000 0002000 00000000045 14161405743 0014251 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	1
1	2
2	1
2	2
3	1
3	2
3	3
4	1
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3083.dat                                                                                            0000600 0004000 0002000 00000000062 14161405743 0014252 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	3	Math
2	2	Physics
3	1	Psychology
4	1	.Net
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                              3085.dat                                                                                            0000600 0004000 0002000 00000000144 14161405743 0014255 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Jand Manas	3.25	IITU	777	1	1
2	Tole Abyl	3.00	KBTU	666	2	2
3	Bait Satb	2.40	Satbayev	555	3	3
\.


                                                                                                                                                                                                                                                                                                                                                                                                                            3087.dat                                                                                            0000600 0004000 0002000 00000000373 14161405743 0014263 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	elvira@gmail.com	Elvira	123	Nugmanova	1
2	anuar@gmail.com	Anuar	123	Borangaziyev	2
3	aldik@gmail.com	Aldiyar	123	Orazbek	3
4	ninja@gmail.com	Raphael	123	Turtle	4
5	oscar@gmail.com	Leonardo	123	Di Caprio	5
6	michael@gmail.com	Michael	123	Grey	3
\.


                                                                                                                                                                                                                                                                     3089.dat                                                                                            0000600 0004000 0002000 00000000326 14161405743 0014263 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Senior Python Developer	2021-07-10	500000	1
2	Senior Java Developer	2020-07-10	490000	2
3	Middle C++ Developer	2016-07-10	800000	2
4	Junior C++ Developer	2021-07-10	350000	3
5	position1	2021-10-12	390000	\N
\.


                                                                                                                                                                                                                                                                                                          restore.sql                                                                                         0000600 0004000 0002000 00000042522 14161405743 0015376 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 13.0
-- Dumped by pg_dump version 13.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "SmartCity";
--
-- Name: SmartCity; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "SmartCity" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';


ALTER DATABASE "SmartCity" OWNER TO postgres;

\connect "SmartCity"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: businessnews; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.businessnews (
    newsid integer NOT NULL,
    heading character varying(255) NOT NULL,
    text character varying(255) NOT NULL,
    authorid integer
);


ALTER TABLE public.businessnews OWNER TO postgres;

--
-- Name: businessnews_newsid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.businessnews_newsid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.businessnews_newsid_seq OWNER TO postgres;

--
-- Name: businessnews_newsid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.businessnews_newsid_seq OWNED BY public.businessnews.newsid;


--
-- Name: place; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.place (
    placeid integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.place OWNER TO postgres;

--
-- Name: place_placeid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.place_placeid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.place_placeid_seq OWNER TO postgres;

--
-- Name: place_placeid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.place_placeid_seq OWNED BY public.place.placeid;


--
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    roleid integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- Name: role_roleid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_roleid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_roleid_seq OWNER TO postgres;

--
-- Name: role_roleid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_roleid_seq OWNED BY public.role.roleid;


--
-- Name: sight; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sight (
    sightid integer NOT NULL,
    address character varying(255) NOT NULL,
    childrenfree boolean NOT NULL,
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL,
    placeid integer
);


ALTER TABLE public.sight OWNER TO postgres;

--
-- Name: sight_sightid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sight_sightid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sight_sightid_seq OWNER TO postgres;

--
-- Name: sight_sightid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sight_sightid_seq OWNED BY public.sight.sightid;


--
-- Name: specialty; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.specialty (
    specialtyid integer NOT NULL,
    hasscholarship boolean NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.specialty OWNER TO postgres;

--
-- Name: specialty_specialtyid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.specialty_specialtyid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.specialty_specialtyid_seq OWNER TO postgres;

--
-- Name: specialty_specialtyid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.specialty_specialtyid_seq OWNED BY public.specialty.specialtyid;


--
-- Name: specialtysubject; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.specialtysubject (
    subjectid integer NOT NULL,
    specialtyid integer NOT NULL
);


ALTER TABLE public.specialtysubject OWNER TO postgres;

--
-- Name: subject; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.subject (
    subjectid integer NOT NULL,
    credits integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.subject OWNER TO postgres;

--
-- Name: subject_subjectid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.subject_subjectid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.subject_subjectid_seq OWNER TO postgres;

--
-- Name: subject_subjectid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.subject_subjectid_seq OWNED BY public.subject.subjectid;


--
-- Name: university; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.university (
    universityid integer NOT NULL,
    address character varying(255) NOT NULL,
    avggpa numeric(19,2) NOT NULL,
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL,
    placeid integer,
    specialtyid integer
);


ALTER TABLE public.university OWNER TO postgres;

--
-- Name: university_universityid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.university_universityid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.university_universityid_seq OWNER TO postgres;

--
-- Name: university_universityid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.university_universityid_seq OWNED BY public.university.universityid;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    userid integer NOT NULL,
    email character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    surname character varying(255) NOT NULL,
    roleid integer
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_userid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_userid_seq OWNER TO postgres;

--
-- Name: users_userid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_userid_seq OWNED BY public.users.userid;


--
-- Name: vacancy; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vacancy (
    vacancyid integer NOT NULL,
    "position" character varying(255) NOT NULL,
    postdate date NOT NULL,
    salary integer NOT NULL,
    placetype integer
);


ALTER TABLE public.vacancy OWNER TO postgres;

--
-- Name: vacancy_vacancyid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vacancy_vacancyid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vacancy_vacancyid_seq OWNER TO postgres;

--
-- Name: vacancy_vacancyid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vacancy_vacancyid_seq OWNED BY public.vacancy.vacancyid;


--
-- Name: businessnews newsid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.businessnews ALTER COLUMN newsid SET DEFAULT nextval('public.businessnews_newsid_seq'::regclass);


--
-- Name: place placeid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.place ALTER COLUMN placeid SET DEFAULT nextval('public.place_placeid_seq'::regclass);


--
-- Name: role roleid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN roleid SET DEFAULT nextval('public.role_roleid_seq'::regclass);


--
-- Name: sight sightid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sight ALTER COLUMN sightid SET DEFAULT nextval('public.sight_sightid_seq'::regclass);


--
-- Name: specialty specialtyid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.specialty ALTER COLUMN specialtyid SET DEFAULT nextval('public.specialty_specialtyid_seq'::regclass);


--
-- Name: subject subjectid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.subject ALTER COLUMN subjectid SET DEFAULT nextval('public.subject_subjectid_seq'::regclass);


--
-- Name: university universityid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.university ALTER COLUMN universityid SET DEFAULT nextval('public.university_universityid_seq'::regclass);


--
-- Name: users userid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN userid SET DEFAULT nextval('public.users_userid_seq'::regclass);


--
-- Name: vacancy vacancyid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vacancy ALTER COLUMN vacancyid SET DEFAULT nextval('public.vacancy_vacancyid_seq'::regclass);


--
-- Data for Name: businessnews; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.businessnews (newsid, heading, text, authorid) FROM stdin;
\.
COPY public.businessnews (newsid, heading, text, authorid) FROM '$$PATH$$/3072.dat';

--
-- Data for Name: place; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.place (placeid, name) FROM stdin;
\.
COPY public.place (placeid, name) FROM '$$PATH$$/3074.dat';

--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (roleid, name) FROM stdin;
\.
COPY public.role (roleid, name) FROM '$$PATH$$/3076.dat';

--
-- Data for Name: sight; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sight (sightid, address, childrenfree, name, phone, placeid) FROM stdin;
\.
COPY public.sight (sightid, address, childrenfree, name, phone, placeid) FROM '$$PATH$$/3078.dat';

--
-- Data for Name: specialty; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.specialty (specialtyid, hasscholarship, name) FROM stdin;
\.
COPY public.specialty (specialtyid, hasscholarship, name) FROM '$$PATH$$/3080.dat';

--
-- Data for Name: specialtysubject; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.specialtysubject (subjectid, specialtyid) FROM stdin;
\.
COPY public.specialtysubject (subjectid, specialtyid) FROM '$$PATH$$/3081.dat';

--
-- Data for Name: subject; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.subject (subjectid, credits, name) FROM stdin;
\.
COPY public.subject (subjectid, credits, name) FROM '$$PATH$$/3083.dat';

--
-- Data for Name: university; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.university (universityid, address, avggpa, name, phone, placeid, specialtyid) FROM stdin;
\.
COPY public.university (universityid, address, avggpa, name, phone, placeid, specialtyid) FROM '$$PATH$$/3085.dat';

--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (userid, email, name, password, surname, roleid) FROM stdin;
\.
COPY public.users (userid, email, name, password, surname, roleid) FROM '$$PATH$$/3087.dat';

--
-- Data for Name: vacancy; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vacancy (vacancyid, "position", postdate, salary, placetype) FROM stdin;
\.
COPY public.vacancy (vacancyid, "position", postdate, salary, placetype) FROM '$$PATH$$/3089.dat';

--
-- Name: businessnews_newsid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.businessnews_newsid_seq', 2, true);


--
-- Name: place_placeid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.place_placeid_seq', 3, true);


--
-- Name: role_roleid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_roleid_seq', 5, true);


--
-- Name: sight_sightid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sight_sightid_seq', 2, true);


--
-- Name: specialty_specialtyid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.specialty_specialtyid_seq', 4, true);


--
-- Name: subject_subjectid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.subject_subjectid_seq', 4, true);


--
-- Name: university_universityid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.university_universityid_seq', 3, true);


--
-- Name: users_userid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_userid_seq', 6, true);


--
-- Name: vacancy_vacancyid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vacancy_vacancyid_seq', 5, true);


--
-- Name: businessnews businessnews_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.businessnews
    ADD CONSTRAINT businessnews_pkey PRIMARY KEY (newsid);


--
-- Name: place place_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.place
    ADD CONSTRAINT place_pkey PRIMARY KEY (placeid);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (roleid);


--
-- Name: sight sight_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sight
    ADD CONSTRAINT sight_pkey PRIMARY KEY (sightid);


--
-- Name: specialty specialty_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.specialty
    ADD CONSTRAINT specialty_pkey PRIMARY KEY (specialtyid);


--
-- Name: subject subject_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.subject
    ADD CONSTRAINT subject_pkey PRIMARY KEY (subjectid);


--
-- Name: university university_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.university
    ADD CONSTRAINT university_pkey PRIMARY KEY (universityid);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (userid);


--
-- Name: vacancy vacancy_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vacancy
    ADD CONSTRAINT vacancy_pkey PRIMARY KEY (vacancyid);


--
-- Name: university fk4opp7nwqy8y0mm9n1j5su49xt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.university
    ADD CONSTRAINT fk4opp7nwqy8y0mm9n1j5su49xt FOREIGN KEY (placeid) REFERENCES public.place(placeid);


--
-- Name: users fk5ogtm7b0y9isqbrtf2g9xjddy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk5ogtm7b0y9isqbrtf2g9xjddy FOREIGN KEY (roleid) REFERENCES public.role(roleid);


--
-- Name: vacancy fk8t5iy5ec6j4q5g26pjgkxf0yi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vacancy
    ADD CONSTRAINT fk8t5iy5ec6j4q5g26pjgkxf0yi FOREIGN KEY (placetype) REFERENCES public.place(placeid);


--
-- Name: specialtysubject fk8whq0riwj9b97443gk30y6wc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.specialtysubject
    ADD CONSTRAINT fk8whq0riwj9b97443gk30y6wc FOREIGN KEY (subjectid) REFERENCES public.subject(subjectid);


--
-- Name: sight fkjj6o810min8l69bqrlevwyiev; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sight
    ADD CONSTRAINT fkjj6o810min8l69bqrlevwyiev FOREIGN KEY (placeid) REFERENCES public.place(placeid);


--
-- Name: specialtysubject fkmv46gcu65mfysfff4vyf9h7am; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.specialtysubject
    ADD CONSTRAINT fkmv46gcu65mfysfff4vyf9h7am FOREIGN KEY (specialtyid) REFERENCES public.specialty(specialtyid);


--
-- Name: businessnews fknxytorp73ypeu5lfxt1uhs7rd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.businessnews
    ADD CONSTRAINT fknxytorp73ypeu5lfxt1uhs7rd FOREIGN KEY (authorid) REFERENCES public.users(userid);


--
-- Name: university fkop50xcb8u3kvdg4na51e8o12n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.university
    ADD CONSTRAINT fkop50xcb8u3kvdg4na51e8o12n FOREIGN KEY (specialtyid) REFERENCES public.specialty(specialtyid);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              