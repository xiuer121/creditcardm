
use creditcardm;



-- ����Ա���ϱ�
DROP TABLE IF EXISTS admin;
create table admin(
	
	id int auto_increment primary key COMMENT '���', 
	account_use tinyint(1) COMMENT '�ʺ�״̬',  
	last_time datetime	COMMENT '�ϴε�¼ʱ��',
	login_num int COMMENT '��¼����',	
	login_time datetime	COMMENT '��¼ʱ��',	
	
	error_num int COMMENT '����������', 
	error_date datetime COMMENT '�������ʱ��', 	
	
	login_name varchar(255) COMMENT '��¼��',
 	password varchar(255) COMMENT '��ѯ����', 
	person_name varchar(255) COMMENT '����',
	tel varchar(255) COMMENT '��ϵ�绰',
	remark text COMMENT '��ע',
	point double comment 'Ա������',
	money double comment 'Ա�����¹���' 
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='����Ա���ϱ�';	

insert into admin(id,account_use,login_name,password,person_name,tel,remark,error_num,login_num) 
				values(1000,1,'admin','admin888','��������Ա','','',0,0);





-- ���ÿ����ϱ�

DROP TABLE IF EXISTS card_info;
create table card_info(
	id int auto_increment primary key COMMENT '���', 
	person_name varchar(20) comment '����',
	admin_id int comment 'Ա��ID',
	card_no varchar(20) comment '����',
	id_no varchar(20) comment '���֤��',
	phone varchar(20) comment '�ֻ�', 
	credits double comment '���ÿ����', 
	money double comment '���׽��',
	card_type int comment '�������� ����>����>���',
	repayment_states int comment '����״̬', 
	card_bank varchar(20) comment '��Ƭ��������',
	repayment_date datetime COMMENT '��������',
	entrust_date datetime comment 'ί������',
	rates double comment '����',
	stay_states boolean comment '�Ƿ�����',
	card_states int comment '���ÿ�״̬�Ƿ�ȡ������ 20ȡ������'
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='���ÿ����ϱ�';	


DROP TABLE IF EXISTS credit_records;
create table credit_records(
	id int auto_increment primary key COMMENT '���', 
	card_info_id int comment '�������ÿ�',
	bank_id int comment '�������п�',
	post_id int comment 'post�����',
	small_ticket_no varchar(50) comment '���ѵ���',
	brush_date datetime comment 'ˢ������',
	brush_money double comment 'ˢ�����',
	brush_type int comment 'ˢ�����ͣ���ˢ����ˢ��',
	entry_date datetime comment '¼������'
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='ˢ����¼��';	



DROP TABLE IF EXISTS post_info;
create table post_info(
	id int auto_increment primary key COMMENT '���',
	admin_id int comment 'Ա��ID',
	post_no varchar(20) comment 'post�����',
	post_title varchar(50) comment 'post����',
	post_rates double comment '����',
	post_money double comment '������',
	post_max_money double comment '����ˢ��'
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='post��';	


DROP TABLE IF EXISTS bank_card_info;
create table bank_card_info(
	id int auto_increment primary key COMMENT '���',
	admin_id int comment 'Ա��ID',
	bank_no varchar(20) comment '���п����',
	bank_title varchar(50) comment '������',
	bank_card_no varchar(50) comment '����',
	bank_money varchar(50) comment '���մ�����'
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='�������п�';	


DROP TABLE IF EXISTS deal_info;
create table deal_info(
		id int auto_increment primary key COMMENT '���',
		admin_id int comment 'Ա��ID',
		card_info_id int comment '�������ÿ�',
		bank_money double comment '������',
		post_money double comment 'ˢ�����',
		deal_states int comment '����״̬10�������20Ϊ��ɴ���ˢ��,30Ϊ������', 
		commit_date date comment '�ύʱ��',
		deal_type int comment '�������� ����>����>���',
		need_money double comment '�������',
		money double comment '�������',
		finsh_state int  comment '���״̬ Ĭ��10 δ��ɡ�20��ɼ���������ڴ�����ˢ�������ڴ������',
		check_state int comment '10Ϊδ����״̬��20Ϊ����״̬',
		check_admin_id int comment '�����ԱID',
		check_date date comment '���ʱ��'  
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='������Ϣ��';

DROP TABLE IF EXISTS heighten_info;
create table heighten_info(
	id int auto_increment primary key COMMENT '���',
	admin_id int comment 'Ա��ID',
	card_info_id int comment '�������ÿ�',
	current_credits double comment '��ǰ���',
	heighten_credits double comment '�ᵽ���',
	card_no varchar(20) comment '����',
	card_bank varchar(20) comment '��������',
	person_name varchar(20) comment '����',
	id_no varchar(20) comment '���֤��',
	phone varchar(20) comment '�ֻ�',
	tel varchar(20) comment '�绰',
	enough_states int comment '����Ҫ��״̬' ,
	all_point double comment '�����ѵ���ȫ��',
	company_point double comment '�����ѵ�����˾',
	balance double comment '���ÿ����',
	staff_point double comment 'Ա������'
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='����';


DROP TABLE IF EXISTS bank_repayment_day;
create table bank_repayment_day(
id int auto_increment primary key COMMENT '���', 
date_title varchar(50) comment '��������',
money_day double comment '���ջ����ܶ�',
bank_card_id int comment '�������п�'
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='���л���ÿ�ռ�¼';


DROP TABLE IF EXISTS post_push_day;
create table post_push_day(
id int auto_increment primary key COMMENT '���', 
date_title varchar(50) comment '��������',
money_day double comment '����ˢ���ܶ�',
post_id int comment '����POST'
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='POSTˢ��ÿ�ռ�¼';


alter table card_info add column card_password varchar(50);
alter table card_info add column query_password varchar(50);