CREATE TABLE student(    
    id VARCHAR(5) NOT NULL,    
    name VARCHAR(20) NOT NULL,    
    age int(3) DEFAULT '0',    
    gender VARCHAR(1),    
    PRIMARY KEY(id)    
)ENGINE=InnoDB DEFAULT CHARSET=utf8;