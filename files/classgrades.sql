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