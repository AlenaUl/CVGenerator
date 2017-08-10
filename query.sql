
/* create table employee(
        id int not null auto_increment,
        firstname varchar(60) default null,
        lastname varchar(60) default null,
        date_of_birth date default null,
        phonenumber varchar(18) not null,
        email varchar(50) default null,
        primary key(id)
);

create table project(
        id int not null auto_increment,
        customer varchar(100) default null,
        topic varchar(200) default null,
        start_date date default null,
        end_date date default null,
        primary key(id)
);
create table job(
        id int not null auto_increment,
        employee_id int not null,
        project_id int not null,
        part_id int not null,
        constraint pk_job primary key(id),
        constraint fk_employee foreign key(employee_id)
                                references employee(id),
        constraint fk_project foreign key(project_id)
                                references project(id),
        constraint fk_part foreign key(part_id)
                                references part(id),
        constraint uq_job unique (project_id, technology_id, part_id)
);
create table technology(
        id int not null auto_increment,
        name varchar(100) default null,
        primary key(id)
);
create table project_technology(
        id int not null auto_increment,
        project_id int not null,
        technology_id int not null,
        constraint pk_protech primary key(id),
        constraint fk_project foreign key(project_id)
                             references project(pr_id),
        constraint fk_technology foreign key(technology_id)
                             references technology(id),
        constraint uq_protech unique (project_id, technology_id)
);

insert into employee (firstname, lastname, date_of_birth, phonenumber, email) values('Tobias', 'Schaber', '1985-08-15', '01736076815', 'tobias.schaber@codecentric.de');

insert into project (customer, topic, start_date, end_date) values('Metro AG', 'Cache auf Basis von Fast-Data Tools', '2016-02-01', '2016-12-01'),
        ('Booxware Softwaresysteme GmbH', 'Evaluierung diverser Messaging-Technologien', '2016-01-01', '2016-02-01'),
        ('Viega GmbH', 'Konzeption und Aufbau eines Elasticsearch-Clusters (Prototyp)', '2015-11-01', '2015-12-01'),
        ('1&1 Internet AG', 'Konzeption und Aufbau eines Realtime-Monitorings für “Overnight-Bestellungen”','2015-11-01', '2015-12-01'),
        ('Hager Elektro', 'Konzeption und Aufbau einer zentralen Identitäts-Management-Plattform','2014-06-01', '2014-12-01'),
        ('Schwäbisch Hall Kredit Services (SHKS)', 'Beratung beim Aufbau einer Integrationsplattform auf Basis von MuleESB','2014-02-01', '2014-06-01'),
        ('Deutsche Bank', 'Anbindung von SAP Business Partner an Orinoco','2013-07-01', '2014-02-01'),
        ('DEKABank', 'Schnittstellen von WebMethods','2013-01-01', '2013-07-01'),
        ('DEKABank', 'Einführung Business Activity Monitoring (BAM) und Complex Event Processing (CEP)','2012-01-01', '2013-01-01'),
        ('DEKABank', 'Integrationsarchitektur','2010-10-01', '2013-07-01');

insert into technology (name) values('Windows XP/7'),('AIX 6.1'),('IBM DB2'),('TIBCO Product Stack'),('Oracle 11g'),
                      ('Informatica PC'),('WebMethods'),('IBM Synergy'),('XML'),('XPath'),('XSLT'),('XSD'),('WSDL'),
                      ('Maestro'),('TIBCO AMX ServiceGrid'),('TIBCO AMX BPM'),('TIBCO Business Events'),('HP ALM'),
                      ('MuleESB'),('Git'),('Jenkins'),('OpenIAM'),('IoT'),('Elasticsearch'),('Java'),('Puppet'),('Redis'),
                      ('Hiera'),('ActiveMQ'),('ActiveMQ Artemis'),('RabbitMQ'),('Apache Cassandra'),('Apache Spark'),('Kubernetes');

insert into project_technology (project_id, technology_id) values(1,24),(1,25),(1,32),(1,33),(1,34),(2,29),
                                (2,30),(2,31),(3,24),(3,26),(3,27),(3,28),(4,24),(4,25),(5,19),(5,22),(5,23),
                                (6,19),(6,20),(6,21),(7,1),(7,4),(7,18),(8,17),(8,15),(8,16),(8,1),(8,2),(8,3),
                                (8,4),(8,5),(8,6),(8,7),(8,8),(8,9),(8,10),(8,11),(8,12),(8,13),(8,14);

create table part(
        id int not null auto_increment,
        name varchar(60) default null,
        primary key(id)
);
        
insert into part (name) values('Consultant'),('Entwickler'),('Operations Architect'),('Integration Architect'),
                                ('Architect'),('Softwareentwickler'),('Tester');

insert into job (employee_id, project_id, part_id) values(1, 1, 1),(1, 1, 2),(1, 2, 1), (1, 3, 1),(1, 4, 2),(1, 4, 3),
                (1, 5, 1),(1, 5, 2),(1, 5, 4),(1, 6, 1),(1, 6, 5),(1, 7, 1),(1, 7, 6),(1, 8, 1),(1, 8, 2),
                (1, 8, 4),(1, 8, 6),(1, 8, 7);   
*/