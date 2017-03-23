create index IX_8F366193 on course_Assignment (assignmentId);
create index IX_4193D98A on course_Assignment (courses_title);
create index IX_8C578E83 on course_Assignment (ms3employeedb_uid);

create index IX_7747EEAF on course_Course (courseId);
create index IX_60AB3A83 on course_Course (title);

create index IX_A3A12C4E on course_course_assignment (courses_title);
create index IX_AE35DF47 on course_course_assignment (ms3employeedb_uid);

create index IX_1C4F41E4 on course_courses (courseId);
create index IX_D55EBB6E on course_courses (title);