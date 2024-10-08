CREATE SEQUENCE author_seq START WITH 1 INCREMENT BY 50;


CREATE SEQUENCE course_id_seq START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE null_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE resource_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE author
(
    id                BIGINT                   NOT NULL,
    creation_date     TIMESTAMP  DEFAULT NOW() NOT NULL,
    last_updated_date TIMESTAMP,
    author_name       VARCHAR(35)              NOT NULL,
    author_email      VARCHAR(50)              NOT NULL,
    author_country    VARCHAR(3) DEFAULT 'IND' NOT NULL,
    author_age        INT        DEFAULT 18    NOT NULL,
    CONSTRAINT pk_author PRIMARY KEY (id)
);

CREATE TABLE authors_courses
(
    author_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    CONSTRAINT pk_authors_courses PRIMARY KEY (author_id, course_id)
);

CREATE TABLE course
(
    course_id          BIGINT                  NOT NULL,
    creation_date      TIMESTAMP DEFAULT NOW() NOT NULL,
    last_updated_date  TIMESTAMP,
    course_title       VARCHAR(255)            NOT NULL,
    course_description VARCHAR(255),
    CONSTRAINT pk_course PRIMARY KEY (course_id)
);

CREATE TABLE lecture
(
    id                BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    creation_date     TIMESTAMP DEFAULT NOW()                 NOT NULL,
    last_updated_date TIMESTAMP,
    lecture_name      VARCHAR(255)                            NOT NULL,
    section_id        BIGINT,
    resource_id       BIGINT,
    CONSTRAINT pk_lecture PRIMARY KEY (id)
);

CREATE TABLE orders
(
    order_name        VARCHAR(255),
    order_description VARCHAR(255),
    order_id          INT       NOT NULL,
    order_date_time   TIMESTAMP NOT NULL,
    street            VARCHAR(255),
    city              VARCHAR(255),
    state             VARCHAR(255),
    zip_code          INT,
    CONSTRAINT pk_orders PRIMARY KEY (order_id, order_date_time)
);

CREATE TABLE resource
(
    id            BIGINT        NOT NULL,
    resource_type VARCHAR(31),
    resource_name VARCHAR(255)  NOT NULL,
    resource_size INT DEFAULT 0 NOT NULL,
    resource_url  VARCHAR(255)  NOT NULL,
    lecture_id    BIGINT,
    duration      INT,
    content       VARCHAR(255),
    type          VARCHAR(255),
    CONSTRAINT pk_resource PRIMARY KEY (id)
);

CREATE TABLE section
(
    id                BIGINT                  NOT NULL,
    creation_date     TIMESTAMP DEFAULT NOW() NOT NULL,
    last_updated_date TIMESTAMP,
    section_name      VARCHAR(255)            NOT NULL,
    section_order     INT       DEFAULT 0     NOT NULL,
    course_id         BIGINT,
    CONSTRAINT pk_section PRIMARY KEY (id)
);

ALTER TABLE author
    ADD CONSTRAINT uc_author_author_email UNIQUE (author_email);

ALTER TABLE lecture
    ADD CONSTRAINT uc_lecture_resource UNIQUE (resource_id);

ALTER TABLE resource
    ADD CONSTRAINT uc_resource_lecture UNIQUE (lecture_id);

ALTER TABLE lecture
    ADD CONSTRAINT FK_LECTURE_ON_RESOURCE FOREIGN KEY (resource_id) REFERENCES resource (id);

ALTER TABLE lecture
    ADD CONSTRAINT FK_LECTURE_ON_SECTION FOREIGN KEY (section_id) REFERENCES section (id);

ALTER TABLE resource
    ADD CONSTRAINT FK_RESOURCE_ON_LECTURE FOREIGN KEY (lecture_id) REFERENCES lecture (id);

ALTER TABLE section
    ADD CONSTRAINT FK_SECTION_ON_COURSE FOREIGN KEY (course_id) REFERENCES course (course_id);

ALTER TABLE authors_courses
    ADD CONSTRAINT fk_autcou_on_author_entity FOREIGN KEY (author_id) REFERENCES author (id);

ALTER TABLE authors_courses
    ADD CONSTRAINT fk_autcou_on_course_entity FOREIGN KEY (course_id) REFERENCES course (course_id);