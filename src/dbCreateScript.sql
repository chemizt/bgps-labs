create table "study_group"
(
    "id" identity not null primary key,
    "name" text default null
);

create table "subject"
(
    "id" identity not null primary key,
    "name" text default null,
    "short_name" text default null
);

create table "exam_type"
(
    "id" identity not null primary key,
    "type" text default null
);

create table "mark"
(
    "id" identity not null primary key,
    "name" text default null,
    "value" text default null
);

create table "study_plan"
(
    "id" identity not null primary key,
    "subject_id" int,
    "exam_type_id" int,
    foreign key("subject_id") references "subject"("id") on delete cascade,
    foreign key("exam_type_id") references "exam_type"("id") on delete cascade
);

create table "student"
(
    "id" identity not null primary key,
    "surname" text default null,
    "name" text default null,
    "second_name" text default null,
    "study_group_id" int,
    foreign key("study_group_id") references "study_group"("id") on delete cascade
);

create table "journal"
(
    "id" identity not null primary key,
    "student_id" int,
    "study_plan_id" int,
    "in_time" boolean not null default true,
    "count" int,
    "mark_id" int,
    foreign key("student_id") references "student"("id") on delete cascade,
    foreign key("study_plan_id") references "study_plan"("id") on delete cascade,
    foreign key("mark_id") references "mark"("id") on delete cascade
)
