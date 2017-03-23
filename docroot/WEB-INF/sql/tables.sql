create table course_Assignment (
	courses_title VARCHAR(75) null,
	ms3employeedb_uid VARCHAR(75) null,
	assignedDate DATE null,
	startDate DATE null,
	endDate DATE null,
	notes VARCHAR(75) null,
	cost VARCHAR(75) null,
	certification BOOLEAN,
	assignmentId LONG not null primary key
);

create table course_Course (
	title VARCHAR(75) not null primary key,
	description VARCHAR(75) null,
	listPrice VARCHAR(75) null,
	provider VARCHAR(75) null,
	courseId LONG
);

create table course_course_assignment (
	courses_title VARCHAR(75) null,
	ms3employeedb_uid VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	notes VARCHAR(75) null,
	cost VARCHAR(75) null,
	certification BOOLEAN,
	assignmentId LONG not null primary key
);

create table course_courses (
	title VARCHAR(75) not null primary key,
	description VARCHAR(75) null,
	listPrice VARCHAR(75) null,
	provider VARCHAR(75) null,
	courseId LONG
);