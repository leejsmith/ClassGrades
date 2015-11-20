
CREATE TABLE tbl_Users (
	userID	INTEGER PRIMARY KEY AUTOINCREMENT,
	username	INTEGER NOT NULL,
	salt	INTEGER NOT NULL,
	passwordSec	INTEGER NOT NULL
);
CREATE TABLE tbl_StudentGroup (
	studentID	INTEGER,
	groupID	INTEGER,
	PRIMARY KEY(studentID,groupID),
	FOREIGN KEY (studentID) REFERENCES tbl_Student(studentID),
	FOREIGN KEY (groupID) REFERENCES tbl_Group (groupID)
);
CREATE TABLE tbl_Student (
	studentID	INTEGER PRIMARY KEY AUTOINCREMENT,
	examNo	INTEGER NOT NULL,
	surname	TEXT NOT NULL,
	forenames	TEXT NOT NULL,
	gender	TEXT NOT NULL,
	regGroup	TEXT NOT NULL,
	pupilPremium	INTEGER,
	senStatus	TEXT,
	catmean	INTEGER,
	averagepts	INTEGER,
	catVerbal	INTEGER,
	catNonVerbal	INTEGER
);
CREATE TABLE tbl_ModuleResult(
	resultID INTEGER PRIMARY KEY AUTOINCREMENT,
	studentID INTEGER NOT NULL,
	moduleID INTEGER NOT NULL,
	resultInt INTEGER,
	FOREIGN KEY (studentID) REFERENCES tbl_Student(studentID),
	FOREIGN KEY (moduleID) REFERENCES tbl_Module(moduleID)
	);
CREATE TABLE tbl_ModuleHomework (
	homeworkID INTEGER PRIMARY KEY AUTOINCREMENT,
	moduleID INTEGER,
	homeworkName TEXT,
	homeworkMaxScore INTEGER,
	FOREIGN KEY (moduleID) REFERENCES tbl_Module(moduleID)
	);
CREATE TABLE tbl_ModuleGroup (
	moduleID INTEGER,
	groupID INTEGER,
	PRIMARY KEY (moduleID, groupID),
	FOREIGN KEY (moduleID) REFERENCES tbl_Module(moduleID),
	FOREIGN KEY (groupID) REFERENCES tbl_Group(groupID)
	);
CREATE TABLE tbl_Module (
	moduleID	INTEGER PRIMARY KEY AUTOINCREMENT,
	moduleName	TEXT
);
CREATE TABLE tbl_HomeworkResult(
	homeworkResultID INTEGER PRIMARY KEY AUTOINCREMENT,
	homeworkID INTEGER,
	studentID INTEGER,
	hwScore INTEGER,
	FOREIGN KEY (homeworkID) REFERENCES tbl_ModuleHomework(homeworkID),
	FOREIGN KEY (studentID) REFERENCES tbl_Student(studentID)
	);
CREATE TABLE tbl_Group (
	groupID	INTEGER PRIMARY KEY AUTOINCREMENT,
	groupName	TEXT NOT NULL
);
CREATE TABLE tbl_Allergy (
	allegyID	INTEGER PRIMARY KEY AUTOINCREMENT,
	studentID	INTEGER NOT NULL,
	allergyName	INTEGER NOT NULL,
	FOREIGN KEY(studentID) REFERENCES tbl_Student(studentID)
);

