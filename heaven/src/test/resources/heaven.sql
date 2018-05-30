-- 회원 그룹 테이블
drop table users_group;
create table users_group(
   ugroup_no varchar2(100) primary key,
   ugroup_name varchar2(100) not null
)

insert into users_group values('1','일반회원');
insert into users_group values('2','단체');
insert into users_group values('3','미승인 단체');
insert into users_group values('4','관리자');
insert into users_group values('5', '탈퇴회원');

select * from users_group



-- 회원 등급 테이블
drop table users_grade;
create table users_grade(
   ugrade_no varchar2(100) primary key,
   ugrade_name varchar2(100) not null
)

insert into users_grade values('1', '씨앗');
insert into users_grade values('2', '새싹');
insert into users_grade values('3', '잎새');
insert into users_grade values('4', '열매');

select * from users_grade



-- 회원 테이블
drop table users;
create table users(
   id varchar2(100) primary key,
   password varchar2(100) not null,
   name varchar2(100) not null,
   birthday date not null,
   gender varchar2(2) not null,
   address varchar2(100) not null,
   email varchar2(100) not null,
   company_no varchar2(100),
   mileage number default 0,
   total_use_mileage number default 0,
   ugroup_no varchar2(100) not null,
   ugrade_no varchar2(100) not null,
   CONSTRAINT fk_users_ugroup_no FOREIGN KEY(ugroup_no) REFERENCES users_group(ugroup_no) ON DELETE CASCADE,
   CONSTRAINT fk_users_ugrade_no FOREIGN KEY(ugrade_no) REFERENCES users_grade(ugrade_no) ON DELETE CASCADE
)

select * from users;

insert into users(id, password, name, birthday, gender, address, email, ugroup_no, ugrade_no)
values('admin','1233','관리자',to_date('1990.01.01','yyyy-mm-dd'),'f','아차산','admin@admi.n','4','4')


--마일리지 거래 분류 테이블
drop table mileage_group;
create table mileage_group(
   mg_no varchar2(100) primary key,
   mg_name varchar2(100) not null
)

insert into mileage_group values('1','충전');
insert into mileage_group values('2','참여');
insert into mileage_group values('3','환전');
insert into mileage_group values('4','지급');

select * from mileage_group;



-- 마일리지 거래 테이블
drop table mileage_trade;
create table mileage_trade(
   mt_no number primary key,
   mt_volume number not null,
   mt_regdate date default sysdate,
   mg_no varchar2(100) not null,
   id varchar2(100) not null,
   CONSTRAINT fk_mileage_trade_mg_no FOREIGN KEY(mg_no) REFERENCES mileage_group(mg_no) ON DELETE CASCADE,
   CONSTRAINT fk_mileage_trade_id FOREIGN KEY(id) REFERENCES users(id) ON DELETE CASCADE
)

-- 마일리지 거래 시퀀스
drop sequence mileage_trade_seq;
create sequence mileage_trade_seq;

select * from mileage_trade;



-- 참여 게시판 분류 테이블
drop table post_group;
create table post_group(
   post_no varchar2(100) primary key,
   post_name varchar2(100) not null
)

insert into post_group values('1', '재능기부');
insert into post_group values('2', '테이킹');

select * from post_group;



-- 참여 진행 상태 테이블
drop table progress_status;
create table progress_status(
	ps_no varchar2(100) primary key,
	ps_name varchar2(100) not null
)

insert into progress_status values('1', '예정');
insert into progress_status values('2', '진행');
insert into progress_status values('3', '종료');
insert into progress_status values('4', '지급완료');

select * from progress_status;



-- 참여 게시판 테이블
drop table join_post;
create table join_post(
   jp_no number primary key, --글번호
   jp_title varchar2(100) not null, --글 제목
   jp_contents clob not null, -- 글 내용
   jp_summary varchar2(100) not null, --글 요약
   jp_place varchar2(100), -- 모임 장소
   jp_app_start_date date not null, -- 신청 시작 날짜
   jp_app_end_date date not null, -- 신청 종료 날짜
   jp_event_start_date date, -- 모임 시작 날짜
   jp_event_end_date date,  -- 모임 끝 날짜
   jp_imgdirectory varchar2(100) not null, -- 대표 이미지 경로
   jp_regdate date default sysdate, -- 작성 일시
   jp_goal_mileage number, --목표 마일리지
   jp_total_mileage number, -- 모금 마일리지
   jp_goal_entry number, -- 목표 참여자 수
   jp_total_entry number, -- 현재 참여자 수
   jp_status varchar2(100) not null, -- 승인 여부
   id varchar2(100) not null, -- 작성자 아이디
   jp_group_no varchar2(100) not null, -- 글 게시판 분류
   jp_progress varchar2(100) not null, -- 참여 진행상태   
   CONSTRAINT fk_join_post_id FOREIGN KEY(id) REFERENCES users(id) ON DELETE CASCADE,
   CONSTRAINT fk_join_post_jp_group_no FOREIGN KEY(jp_group_no) REFERENCES post_group(post_no) ON DELETE CASCADE,
   CONSTRAINT fk_join_post_ps_no FOREIGN KEY(jp_progress) REFERENCES progress_status(ps_no) ON DELETE CASCADE
)

-- 참여게시판 게시글 시퀀스
drop sequence join_post_seq;
create sequence join_post_seq;

select * from join_post;


-- 참여 테이블
drop table users_activity;
create table users_activity(
   u_no number primary key,
   u_regdate date default sysdate,
   u_mileage number not null,
   cheerup_message varchar2(200) default '당신을 응원합니다',
   id varchar2(100) not null,
   jp_no number not null,
   CONSTRAINT fk_users_activity_id FOREIGN KEY(id) REFERENCES users(id) ON DELETE CASCADE,
   CONSTRAINT fk_users_activity_jp_no FOREIGN KEY(jp_no) REFERENCES join_post(jp_no) ON DELETE CASCADE
)


-- 참여 시퀀스
drop sequence users_activity_seq;
create sequence users_activity_seq;

select * from users_activity; 



--후기 게시판 테이블
drop table review;
create table review(
   r_no number primary key,
   r_title varchar2(100) not null,
   r_contents clob not null,
   r_regdate date default sysdate,
   r_rate number not null,
   ua_no number not null,
   CONSTRAINT fk_review_ua_no FOREIGN KEY(ua_no) REFERENCES users_activity(u_no) ON DELETE CASCADE
)

--후기 게시판 시퀀스
drop sequence review_seq;
create sequence review_seq;

select * from review;



--사이트 문의 테이블
drop table question;
create table question(
   q_no number primary key,
   thread number not null,
   q_title varchar2(100),
   q_contents clob,
   q_regdate date default sysdate,
   q_parent_no number default 0,
   q_status varchar2(100) default '처리중',
   id varchar2(100) not null,
   CONSTRAINT fk_question_id FOREIGN KEY(id) REFERENCES users(id) ON DELETE CASCADE
)

--사이트 문의 시퀀스
drop sequence question_seq;
create sequence question_seq;


select * from question;



-- 인터뷰(이달의 기부자) 게시판 테이블 
drop table interview_post;
create table interview_post(
	ip_no number primary key,
	ip_title varchar2(100) not null,
	ip_regdate date default sysdate,
	ip_imgdirectory varchar2(100) not null,
	id varchar2(100) not null,
	CONSTRAINT fk_interview_post_id FOREIGN KEY(id) REFERENCES users(id) ON DELETE CASCADE
)

-- 인터뷰 게시판 시퀀스
drop sequence interview_post_seq;
create sequence interview_post_seq;

select * from interview_post;



-- 인터뷰 질문 답변 테이블
drop table interview_qna
create table interview_qna(
	iq_no number primary key,
	iq_question varchar2(100),
	iq_answer varchar2(100),
	ip_no number not null,
	CONSTRAINT fk_interview_qna_ip_no FOREIGN KEY(ip_no) REFERENCES interview_post(ip_no) ON DELETE CASCADE
)

-- 인터뷰 질문 답변 시퀀스
drop sequence interview_qna_seq;
create sequence interview_qna_seq;

select * from interview_qna;



-- 인터뷰 게시판 댓글
drop table interview_post_reply
create table interview_post_reply(
	ipr_no number primary key,
	ipr_content varchar2(100) not null,
	ipr_regdate date default sysdate,
	id varchar2(100) not null,
	ip_no number not null,
	CONSTRAINT fk_interview_post_reply_id FOREIGN KEY(id) REFERENCES users(id) ON DELETE CASCADE,
	CONSTRAINT fk_interview_post_reply_ip_no FOREIGN KEY(ip_no) REFERENCES interview_post(ip_no) ON DELETE CASCADE
)

select * from interview_post_reply;
