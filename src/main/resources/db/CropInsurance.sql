CREATE TABLE "CROP_INSURANCE"(
   "SERIAL_NO" NUMBER GENERATED BY DEFAULT AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20,
	"MANDAL_NAME" VARCHAR2(100 BYTE),
	"VILLAGE_NAME" VARCHAR2(100 BYTE),
	"NAME_OF_THE_BENEFICIARY" VARCHAR2(100 BYTE),
	"CROP" VARCHAR2(100 BYTE),
	"EXTENT_HA" NUMBER,
	"CLAIM_AMOUNT_RS" NUMBER(*,0),
	"CATEGORY_LOANEE_NON_LOANEE" VARCHAR2(10 BYTE),
	"BANK_NAME" VARCHAR2(100 BYTE),
	"BRANCH_NAME" VARCHAR2(100 BYTE),
	"ACCOUNT_NUMBER" NUMBER,
	 CONSTRAINT "SERIAL_NO_PK" PRIMARY KEY ("SERIAL_NO")
   ) ;