CREATE TABLE teacher (
    id BIGINT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    room_number INT
);

CREATE TABLE project (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(255)
);

CREATE TABLE project_teacher (
    project_id BIGINT,
    teacher_id BIGINT,
    PRIMARY KEY (project_id, teacher_id),
    FOREIGN KEY (project_id) REFERENCES project (id),
    FOREIGN KEY (teacher_id) REFERENCES teacher (id)
);

CREATE TABLE student (
    catalog_number INT,
    clazz VARCHAR(10),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    PRIMARY KEY (clazz, catalog_number)
);

CREATE TABLE task (
    id BIGINT PRIMARY KEY,
    title VARCHAR(100),
    hours_worked INT,
    project_id BIGINT,
    student_catalog_number INT,
    student_clazz VARCHAR(10),
    FOREIGN KEY (project_id) REFERENCES project (id),
    FOREIGN KEY (student_clazz, student_catalog_number) REFERENCES student (clazz, catalog_number)
);

INSERT INTO teacher (id, first_name, last_name, room_number) VALUES
                                                                 (1, 'Gerald', 'Aistleitner', 35),
                                                                 (2, 'Peter', 'Bauer', 120),
                                                                 (3, 'Dietmar', 'Steiner', 45),
                                                                 (4, 'Thomas', 'Stuetz', 210),
                                                                 (5, 'Franz', 'Auernig', 55),
                                                                 (6, 'Erich', 'Mayr', 145),
                                                                 (7, 'Herbert', 'Lackinger', 25);

INSERT INTO project (id, name, description) VALUES
                                                (1, 'Cybersecurity Enhancement Initiative', 'Develop advanced strategies for enhancing cybersecurity measures within the school network.'),
                                                (2, 'Data Analytics for Academic Performance', 'Implement data analytics techniques to analyze academic performance data and provide insights for improvement.'),
                                                (3, 'Virtual Reality in Education', 'Explore the integration of virtual reality technologies to enhance the learning experience in various subjects.'),
                                                (4, 'Blockchain for School Records', 'Investigate the feasibility of using blockchain technology to secure and manage school records efficiently.'),
                                                (5, 'Coding Challenge Platform', 'Develop a platform for organizing coding challenges to promote programming skills among students.');

INSERT INTO project_teacher (project_id, teacher_id) VALUES
                                                         (1, 1), (1, 2),
                                                         (2, 3), (2, 6), (2, 7),
                                                         (3, 4), (3, 5),
                                                         (4, 2),
                                                         (5, 1), (5, 2), (5, 3);

INSERT INTO student (catalog_number, clazz, first_name, last_name) VALUES
                                                                       (1, '4XHIF', 'Sophie', 'Mueller'),
                                                                       (1, '4YHIF', 'Markus', 'Schneider'),
                                                                       (1, '4XHITM', 'Lena', 'Mayer'),
                                                                       (2, '4YHIF', 'David', 'Fischer'),
                                                                       (2, '4XHIF', 'Anna', 'Gruber'),
                                                                       (3, '4YHIF', 'Max', 'Wagner'),
                                                                       (3, '4XHIF', 'Julia', 'Schmidt'),
                                                                       (2, '4XHITM', 'Andreas', 'Weber'),
                                                                       (4, '4YHIF', 'Hannah', 'Koch'),
                                                                       (3, '4XHITM', 'Michael', 'Bauer'),
                                                                       (4, '4XHIF', 'Sebastian', 'Huber'),
                                                                       (5, '4YHIF', 'Jessica', 'Hoffmann'),
                                                                       (5, '4XHIF', 'Daniel', 'Schulz'),
                                                                       (4, '4XHITM', 'Sarah', 'Williams'),
                                                                       (6, '4YHIF', 'Matthias', 'Mueller');

INSERT INTO task (id, title, hours_worked, project_id, student_catalog_number, student_clazz) VALUES
                                                                                                  (1, 'Database Design for New Project', 18, 2, 1, '4XHITM'),
                                                                                                  (2, 'Frontend Development for Website', 25, 4, 1, '4YHIF'),
                                                                                                  (3, 'User Interface Optimization', 12, 3, 1, '4XHIF'),
                                                                                                  (4, 'Algorithm Implementation', 20, 5, 2, '4XHITM'),
                                                                                                  (5, 'Statistical Analysis for Research', 15, 2, 2, '4YHIF'),
                                                                                                  (6, 'Content Creation for Social Media', 10, 3, 2, '4XHIF'),
                                                                                                  (7, 'Programming Competition Coordination', 22, 5, 3, '4YHIF'),
                                                                                                  (8, 'Event Planning for Language Exchange', 8, 4, 3, '4XHIF'),
                                                                                                  (9, 'Penetration Testing for Network Security', 30, 1, 4, '4XHIF'),
                                                                                                  (10, 'Virtual Reality Application Development', 18, 3, 5, '4XHIF'),
                                                                                                  (11, 'Database Migration for Project Upgrade', 15, 2, 3, '4XHITM'),
                                                                                                  (12, 'Mobile App UI/UX Design', 22, 4, 4, '4YHIF'),
                                                                                                  (13, 'Graphic Illustrations for Presentations', 10, 3, 1, '4XHIF'),
                                                                                                  (14, 'Code Optimization and Refactoring', 18, 5, 4, '4XHITM'),
                                                                                                  (15, 'Data Visualization for Academic Report', 14, 2, 5, '4YHIF'),
                                                                                                  (16, 'Social Media Marketing Campaign', 12, 3, 2, '4XHIF'),
                                                                                                  (17, 'Mathematics Quiz Questions Creation', 20, 5, 6, '4YHIF'),
                                                                                                  (18, 'Event Coordination for Language Exchange', 10, 4, 3, '4XHIF'),
                                                                                                  (19, 'Network Security Assessment', 25, 1, 4, '4XHIF'),
                                                                                                  (20, 'Virtual Reality Simulation Testing', 18, 3, 5, '4XHIF'),
                                                                                                  (21, 'Backend Development for New Project', 18, 2, 1, '4XHITM'),
                                                                                                  (22, 'Mobile App Backend Integration', 25, 4, 1, '4YHIF'),
                                                                                                  (23, 'Website Content Management', 12, 3, 1, '4XHIF'),
                                                                                                  (24, 'Machine Learning Algorithm Implementation', 20, 5, 2, '4XHITM'),
                                                                                                  (25, 'Statistical Modeling for Research', 15, 2, 2, '4YHIF'),
                                                                                                  (26, 'Social Media Content Creation', 10, 3, 2, '4XHIF'),
                                                                                                  (27, 'Programming Workshop Coordination', 22, 5, 3, '4YHIF'),
                                                                                                  (28, 'Language Exchange Event Promotion', 8, 4, 3, '4XHIF'),
                                                                                                  (29, 'Security Patch Implementation', 30, 1, 4, '4XHIF'),
                                                                                                  (30, 'Virtual Reality Environment Design', 18, 3, 5, '4XHIF'),
                                                                                                  (31, 'Mobile App Testing and QA', 20, 1, 4, '4YHIF');
