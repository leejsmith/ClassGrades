CREATE TABLE tbl_Users(
    userID INTEGER PRIMARY KEY AUTOINCREMENT,
    userName TEXT,
    salt TEXT,
    passwordSec TEXT,
    admin INTEGER
);

CREATE TABLE tbl_Student(
    studentID INTEGER PRIMARY KEY AUTOINCREMENT,
    surname TEXT,
    forename TEXT,
    regGroup TEXT,
    gender TEXT,
    examNumber INTEGER,
    pupilPremium INTEGER,
    eal INTEGER,
    catMean INTEGER,
    catVerbal INTEGER,
    catNonVerbal INTEGER,
    catQuant INTEGER
);

CREATE TABLE tbl_Sen(
    senID INTEGER PRIMARY KEY AUTOINCREMENT,
    senName TEXT
);

CREATE TABLE tbl_StudentSen (
    studentID INTEGER,
    senID INTEGER,
    PRIMARY KEY(studentID, senID),
    FOREIGN KEY(studentID) REFERENCES tbl_Student(studentID),
    FOREIGN KEY(senID) REFERENCES tbl_Sen(senID)
);

CREATE TABLE tbl_Allergy(
    allergyID INTEGER PRIMARY KEY AUTOINCREMENT,
    allergyName TEXT
);

CREATE TABLE tbl_StudentAllergy(
    studentID INTEGER,
    allergyID INTEGER,
    PRIMARY KEY (studentID, allergyID),
    FOREIGN KEY (studentID) REFERENCES tbl_Student(studentID),
    FOREIGN KEY (allergyID) REFERENCES tbl_Allergy(allergyID)
);

CREATE TABLE tbl_Group(
    groupID INTEGER PRIMARY KEY AUTOINCREMENT,
    groupName TEXT
);

CREATE TABLE tbl_StudentGroup(
    groupID INTEGER,
    studentID INTEGER,
    PRIMARY KEY (groupID, studentID),
    FOREIGN KEY (groupID) REFERENCES tbl_Group(groupID),
    FOREIGN KEY (studentID) REFERENCES tbl_Student(studentID)
);

CREATE TABLE tbl_Course(
    courseID INTEGER PRIMARY KEY AUTOINCREMENT,
    courseName TEXT
);

CREATE TABLE tbl_CourseGroup(
    courseID INTEGER,
    groupID INTeGER,
    PRIMARY KEY (courseID, groupID),
    FOREIGN KEY (courseID) REFERENCES tbl_Course(courseID),
    FOREIGN KEY (groupID) REFERENCES tbl_Group(groupID)
);

CREATE TABLE tbl_Module(
    moduleID INTEGER PRIMARY KEY AUTOINCREMENT,
    moduleName TEXT
);

CREATE TABLE tbl_CourseModule (
    courseID INTEGER,
    moduleID INTEGER,
    PRIMARY KEY (courseID, moduleID),
    FOREIGN KEY (moduleID) REFERENCES tbl_Module(moduleID),
    FOREIGN KEY (courseID) REFERENCES tbl_Course(courseID)
);