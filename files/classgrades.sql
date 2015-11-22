CREATE TABLE tbl_student(
    studentID INTEGER PRIMARY KEY AUTOINCREMENT,
    examNumber INTEGER,
    surname TEXT,
    forenames TEXT,
    gender TEXT,
    regGroup TEXT,
    senStatus TEXT,
    pupilPremium BOOL,
    catMean INTEGER,
    catVerbal INTEGER,
    catNonVerbal INTEGER,
    averagePts INTEGER
);

CREATE TABLE tbl_Group(
    groupID INTEGER PRIMARY KEY AUTOINCREMENT,
    groupName TEXT
);

CREATE TABLE tbl_Unit(
    unitID INTEGER PRIMARY KEY AUTOINCREMENT,
    unitName TEXT
);

CREATE TABLE tbl_UnitGroup(
    unitID INTEGER NOT NULL,
    groupID INTEGER NOT NULL
    PRIMARY KEY (unitID, groupID),
    FOREIGN KEY (unitID) REFERENCES tbl_Unit(unitID),
    FOREIGN KEY (groupID) REFERENCES tbl_Group(groupID)
);

CREATE TABLE tbl_Module (
    moduleID INTEGER PRIMARY KEY AUTOINCREMENT,
    moduleName TEXT
);

CREATE TABLE tbl_ModuleResult (
    studentID INTEGER NOT NULL,
    moduleID INTEGER NOT NULL,
    score INTEGER,
    PRIMARY KEY (studentID, moduleID),
    FOREIGN KEY (studentID) REFERENCES tbl_Student(studentID),
    FOREIGN KEY (moduleID) REFERENCES tbl_Module(moduleID)
);

CREATE TABLE tbl_Homework(
    homeworkID INTEGER PRIMARY KEY AUTOINCREMENT,
    moduleID INTEGER,
    homeworkName TEXT,
    homeworkMax INTEGER,
    FOREIGN KEY (moduleID) REFERENCES tbl_Module(moduleID)
);

CREATE TABLE tbl_HomeworkResult (
    homeworkID INTEGER,
    studentID INTEGER,
    homeworkScore INTEGER,
    PRIMARY KEY (homeworkID, studentID),
    FOREIGN KEY (homeworkID) REFERENCES tbl_Homework(homeworkID),
    FOREIGN KEY (studentID) REFERENCES tbl_Student(studentID)
);

CREATE TABLE tbl_Allergy (
    allergyID INTEGER PRIMARY KEY AUTOINCREMENT,
    allergyName TEXT
);

CREATE TABLE tbl_StudentAllergy (
    studentID INTEGER,
    allergyID INTEGER,
    PRIMARY KEY (studentID,allergyID),
    FOREIGN KEY (studentID) REFERENCES tbl_Student(studentID),
    FOREIGN KEY (allergyID) REFERENCES tbl_Allergy(allergyID)
);

CREATE TABLE tbl_Users (
    userID INTEGER PRIMARY KEY AUTOINCREMENT,
    userName TEXT,
    salt TEXT,
    passwordSec TEXT
);