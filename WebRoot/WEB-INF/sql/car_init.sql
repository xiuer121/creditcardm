
use creditcardm;



-- 管理员资料表
DROP TABLE IF EXISTS admin;
create table admin(
	
	id int auto_increment primary key COMMENT '编号', 
	account_use tinyint(1) COMMENT '帐号状态',  
	last_time datetime	COMMENT '上次登录时间',
	login_num int COMMENT '登录次数',	
	login_time datetime	COMMENT '登录时间',	
	
	error_num int COMMENT '密码错误次数', 
	error_date datetime COMMENT '密码错误时间', 	
	
	login_name varchar(255) COMMENT '登录名',
 	password varchar(255) COMMENT '查询密码', 
	person_name varchar(255) COMMENT '姓名',
	tel varchar(255) COMMENT '联系电话',
	remark text COMMENT '备注',
	point double comment '员工返点',
	money double comment '员工当月工资' 
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='管理员资料表';	

insert into admin(id,account_use,login_name,password,person_name,tel,remark,error_num,login_num) 
				values(1000,1,'admin','admin888','超级管理员','','',0,0);





-- 信用卡资料表

DROP TABLE IF EXISTS card_info;
create table card_info(
	id int auto_increment primary key COMMENT '编号', 
	person_name varchar(20) comment '姓名',
	admin_id int comment '员工ID',
	card_no varchar(20) comment '卡号',
	id_no varchar(20) comment '身份证号',
	phone varchar(20) comment '手机', 
	credits double comment '信用卡额度', 
	money double comment '交易金额',
	card_type int comment '所属类型 代还>套现>提额',
	repayment_states int comment '还款状态', 
	card_bank varchar(20) comment '卡片所属银行',
	repayment_date datetime COMMENT '还款日期',
	entrust_date datetime comment '委托日期',
	rates double comment '费率',
	stay_states boolean comment '是否留卡',
	card_states int comment '信用卡状态是否取消交易 20取消交易'
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='信用卡资料表';	


DROP TABLE IF EXISTS credit_records;
create table credit_records(
	id int auto_increment primary key COMMENT '编号', 
	card_info_id int comment '所属信用卡',
	bank_id int comment '所用银行卡',
	post_id int comment 'post机编号',
	small_ticket_no varchar(50) comment '消费单号',
	brush_date datetime comment '刷卡日期',
	brush_money double comment '刷卡金额',
	brush_type int comment '刷卡类型，分刷出，刷入',
	entry_date datetime comment '录入日期'
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='刷卡记录表';	



DROP TABLE IF EXISTS post_info;
create table post_info(
	id int auto_increment primary key COMMENT '编号',
	admin_id int comment '员工ID',
	post_no varchar(20) comment 'post机编号',
	post_title varchar(50) comment 'post名称',
	post_rates double comment '费率',
	post_money double comment '当天金额',
	post_max_money double comment '允许刷出'
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='post机';	


DROP TABLE IF EXISTS bank_card_info;
create table bank_card_info(
	id int auto_increment primary key COMMENT '编号',
	admin_id int comment '员工ID',
	bank_no varchar(20) comment '银行卡编号',
	bank_title varchar(50) comment '开号名',
	bank_card_no varchar(50) comment '卡号',
	bank_money varchar(50) comment '当日存入金额'
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='还款银行卡';	


DROP TABLE IF EXISTS deal_info;
create table deal_info(
		id int auto_increment primary key COMMENT '编号',
		admin_id int comment '员工ID',
		card_info_id int comment '所属信用卡',
		bank_money double comment '存入金额',
		post_money double comment '刷出金额',
		deal_states int comment '交易状态10及存入金额，20为完成存入刷出,30为提额操作', 
		commit_date date comment '提交时间',
		deal_type int comment '所属类型 代还>精养>提额',
		need_money double comment '代还金额',
		money double comment '产生金额',
		finsh_state int  comment '完成状态 默认10 未完成。20完成即存入金额等于代还金额。刷出金额等于代还金额',
		check_state int comment '10为未结算状态，20为结算状态',
		check_admin_id int comment '审核人员ID',
		check_date date comment '审核时间'  
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='交易信息表';

DROP TABLE IF EXISTS heighten_info;
create table heighten_info(
	id int auto_increment primary key COMMENT '编号',
	admin_id int comment '员工ID',
	card_info_id int comment '所属信用卡',
	current_credits double comment '当前额度',
	heighten_credits double comment '提到额度',
	card_no varchar(20) comment '卡号',
	card_bank varchar(20) comment '所属银行',
	person_name varchar(20) comment '姓名',
	id_no varchar(20) comment '身份证号',
	phone varchar(20) comment '手机',
	tel varchar(20) comment '电话',
	enough_states int comment '符合要求状态' ,
	all_point double comment '手续费点数全部',
	company_point double comment '手续费点数公司',
	balance double comment '信用卡余额',
	staff_point double comment '员工点数'
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='提额表';


DROP TABLE IF EXISTS bank_repayment_day;
create table bank_repayment_day(
id int auto_increment primary key COMMENT '编号', 
date_title varchar(50) comment '所属日期',
money_day double comment '当日还卡总额',
bank_card_id int comment '所属银行卡'
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='银行还卡每日记录';


DROP TABLE IF EXISTS post_push_day;
create table post_push_day(
id int auto_increment primary key COMMENT '编号', 
date_title varchar(50) comment '所属日期',
money_day double comment '当日刷卡总额',
post_id int comment '所属POST'
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='POST刷卡每日记录';


alter table card_info add column card_password varchar(50);
alter table card_info add column query_password varchar(50);