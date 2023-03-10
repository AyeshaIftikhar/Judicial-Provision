package com.ayesha.judicial_provision;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

public class database extends SQLiteOpenHelper {
    static String DATABASE_NAME="JD_PROVISION_DB";
    private  static final int DataBase_Version=1;

    // category table//
    public static final String KEY_IDc="id";
    public static final String Category_TABLE_NAME ="CategoryTable";
    public static final String Key_Category_Name ="Category_name";


    //////Subcategory ////
    public static final String KEY_IDs="id";
    public static final String SUB_CATEGORY_TABLE="SubCategoryTable";
    public static final String SUB_CATEGORY_Name="Sub_Category_name";
    public static final String CATEGORY_Name="Category_name";

    //////Appeal///////

    public static final String appeal_table_name ="Appeal_table";

    public static String  idappeal="ID", appealto="Appeal_to", appealfrom="Appeal_From", casenoappeal="Case_No ",
            subject="Subject", descriptionappeal="Description", date="Date";

    ////////Cases//////

    public static final String cases_table_name ="Cases_table";

    public static String  idcases="ID", casenocases="Case_No", casesubject="Case_subject",
            registerby="Registering_by", descriptioncases="Description",otherref="Other_ref",
            assignedlawyer="Assigned_Lawyer", lawno="Law_no", casenature="Case_Nature";

    ////////////CASESDATA//////
    public static final String casesdata_table_name ="CasesData_table";

    public static String  cdid="ID", dateofhearing="Date_of_Hearing", dateoftermination="Date_of_Termination",
            shortsummaryofhearing="Short_summary_of_hearing", summaryoftermination="Summary_of_termination",
            caseno="Case_no";

    ////////Client///////////

    public static final String client_table_name ="Client_table";

    public static String  clientid="ID", clientname="Client_Name", phone="Phone", email="Email",
            address="Address", dateofadding="Date_of_Adding";
    public database(Context context) {
        super(context,DATABASE_NAME,null,DataBase_Version);
    }

    ///////////LAWSDB////////////
    public static final String LAW_TABLE_NAME="Laws_Table";
    public static final String KEY_ID="id";
    public static final String LAW_Name="Law_name";
    public static final String Key_Law_Number="Law_number";
    public static final String KEY_Subject="subject";
    public static final String Key_Description="Description";
    public static final String Key_Condition="Condition";
    public static final String Key_Panelty="Panelty";
    public static final String key_Sub_Category="Sub_Category_name";
    public static final String Key_Date="Date";
    public static final String Key_Category="Category";

    //////LAWYERS/////////
    public static final String lawyers_table_name ="Lawyers_table";


    public static String  lawyerid="Lawyer_id",lawyerno="Lawyer_no", lawyername="Lawyer_Name"
            ,speciality="Speciality", lawyerphone="lawyer_Phone", lawyeremail="lawyer_Email",
            lawyeraddress="lawyer_Address", Lawyer_password ="lawyer_Password",
            dateofcreation="lawyer_Date_of_creation";

    /* Admin///////public static final String admin_table_name ="Admin_table";
    public static String  idadmin="ref_id", adminname="username", adminpassword="Password", admincontact="Phone_no"; */

    ///////References//////
    public static final String references_table_name ="References_table";

    public static String ref_id ="ID",idreferences="ID_ref", authorname="Law_Name",references_date ="Date", book="BOOK",
            chapter="Chapter", page="Page" ;
    ///////Users//////
    public static final String user_table_name ="Users_table";

    public static String  idusers="user_ID", username="User_Name",
            user_address="user_Address", user_phone="user_Phone_no",
            user_email="user_Email", user_password="user_Password",
            user_dateofcreation="user_Date_of_creation";

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE "+ Category_TABLE_NAME +" ("+KEY_IDc+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ""+ Key_Category_Name +" TEXT)";

        database.execSQL(CREATE_TABLE);
        Log.d("Table","CREATE TABLE "+ Category_TABLE_NAME +" ("+KEY_IDc+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ""+ Key_Category_Name +" TEXT)");

        /////Subcategory////


        String CREATE_TABLE2="CREATE TABLE "+SUB_CATEGORY_TABLE+" ("+KEY_IDs+" INTEGER PRIMARY KEY AUTOINCREMENT,"  +
                ""+SUB_CATEGORY_Name+" TEXT, "+CATEGORY_Name+" TEXT)";

        database.execSQL(CREATE_TABLE2);
        Log.d("Table","CREATE TABLE "+SUB_CATEGORY_TABLE+" ("+KEY_IDs+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ""+SUB_CATEGORY_Name+" TEXT, "+CATEGORY_Name+" TEXT)");


        //////////////APPEAL////////

            String CREATE_TABLE3 =  "CREATE TABLE " + appeal_table_name+ "( " + idappeal + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    ""+appealto+" TEXT,"+appealfrom+" TEXT ," + casenoappeal +" INTEGER,"+subject+" TEXT," +
                    descriptionappeal + " TEXT,"+date+" TEXT)";
        database.execSQL(CREATE_TABLE3);
        Log.d("Table","CREATE TABLE " + appeal_table_name+ "( " + idappeal + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+appealto+" TEXT,"+appealfrom+" TEXT ," + casenoappeal +" INTEGER,"+subject+" TEXT," +
                descriptionappeal + " TEXT,"+date+" TEXT)");

            ////////////////CASES//////
        String CREATE_TABLE4 =  "CREATE TABLE " + cases_table_name+ "( " + idcases + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +casenocases+" INTEGER,"+registerby+" INTEGER  ,"+casesubject+" TEXT,"+descriptioncases+" TEXT,"+lawno+" " +
                "INTEGER," + otherref + " TEXT,"+assignedlawyer+" TEXT,"+casenature+" TEXT)";

        database.execSQL(CREATE_TABLE4);
        Log.d("Table","CREATE TABLE " + cases_table_name+ "( " + idcases + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +casenocases+" INTEGER,"+registerby+" INTEGER  ,"+casesubject+" TEXT,"+descriptioncases+" TEXT,"+lawno+" " +
                "INTEGER," + otherref + " TEXT,"+assignedlawyer+" TEXT,"+casenature+" TEXT)");

        ///////CASESDATA/////////
        String CREATE_TABLE5 =  "CREATE TABLE " + casesdata_table_name+ "( " + cdid + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+dateofhearing+" TEXT,"+dateoftermination+" TEXT ,"+shortsummaryofhearing+" TEXT," +
                summaryoftermination + " TEXT,"+caseno+" TEXT)";

        database.execSQL(CREATE_TABLE5);
        Log.d("Table ","CREATE TABLE " + casesdata_table_name+ "( " + cdid + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+dateofhearing+" TEXT,"+dateoftermination+" TEXT ,"+shortsummaryofhearing+" TEXT," +
                summaryoftermination + " TEXT,"+caseno+" TEXT)");


        //////////CLIENT//////////////
        String CREATE_TABLE6 =  "CREATE TABLE " + client_table_name+ "( " + clientid + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+clientname+" TEXT,"+phone+" INTEGER ,"+email+" TEXT," + address +
                " TEXT,"+dateofadding+" TEXT)";
        database.execSQL(CREATE_TABLE6);
        Log.d("Table ","CREATE TABLE " + client_table_name+ "( " + clientid + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                        ""+clientname+" TEXT,"+phone+" INTEGER ,"+email+" TEXT," + address +
                        " TEXT,"+dateofadding+" TEXT)");
        ///////LAWSDB/////////

        String CREATE_TABLE7="CREATE TABLE "+LAW_TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ""+Key_Law_Number+" TEXT, "+LAW_Name+" TEXT, "+KEY_Subject+" TEXT, "+Key_Description+" TEXT, " +
                ""+Key_Condition+" TEXT, "+Key_Panelty+" TEXT, "+Key_Date+" TEXT/*DATETIME DEFAULT CURRENT_TIMESTAMP*/, "+key_Sub_Category+" TEXT, " +
                ""+Key_Category+" TEXT )";

        database.execSQL(CREATE_TABLE7);
        Log.d("Table ",CREATE_TABLE7);

        ///////LAWYERS///////
        String CREATE_TABLE8 =  "CREATE TABLE " + lawyers_table_name+ "( " + lawyerid + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+lawyerno+" INTEGER,"+lawyername+" TEXT ,"+speciality+" TEXT," + lawyerphone + " TEXT," + lawyeremail +
                " TEXT,"+lawyeraddress+" TEXT," + Lawyer_password + " TEXT,"+dateofcreation+" TEXT)";

        database.execSQL(CREATE_TABLE8);
        Log.d("Table ","CREATE TABLE " + lawyers_table_name+ "( " + lawyerid + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+lawyerno+" INTEGER,"+lawyername+" TEXT ,"+speciality+" TEXT," + phone + " TEXT," + email +
                " TEXT,"+address+" TEXT," + Lawyer_password + " TEXT,"+dateofcreation+" TEXT)");

    /*dmin/////////
        String CREATE_TABLE9 =  "CREATE TABLE " + admin_table_name+ "( " + idadmin + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+adminname+" TEXT,"+adminpassword+" TEXT ,"+admincontact+" TEXT)";

        database.execSQL(CREATE_TABLE9);
        Log.d("Table ", "CREATE TABLE " + admin_table_name+ "( " + idadmin + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+adminname+" TEXT,"+adminpassword+" TEXT ,"+admincontact+" TEXT)"); */


        //////References//////
        String CREATE_TABLE10 =  "CREATE TABLE " + references_table_name+ "( " + ref_id + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+idreferences+" TEXT,"+authorname+" TEXT ,"+book+" TEXT," + chapter + " TEXT,"+page+" TEXT)";

        database.execSQL(CREATE_TABLE10);
        Log.d("Table ","CREATE TABLE " + references_table_name+ "( " + ref_id + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+idreferences+" TEXT,"+authorname+" TEXT ,"+book+" TEXT," + chapter + " TEXT,"+page+" TEXT)");

        /////users///////
        String CREATE_TABLE11 =  "CREATE TABLE " + user_table_name+ "( " + idusers + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+username+" TEXT,"+user_address+" TEXT ,"+user_phone+" TEXT," + user_email + " TEXT,"+user_password+" TEXT,"+
                user_dateofcreation+" TEXT)";

        database.execSQL(CREATE_TABLE11);
        Log.d("Table ", "CREATE TABLE " + user_table_name+ "( " + idusers + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ""+username+" TEXT,"+user_address+" TEXT ,"+user_phone+" TEXT," + user_email + " TEXT,"+user_password+" TEXT,"+
                user_dateofcreation+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+ Category_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+appeal_table_name);
        db.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+cases_table_name);
        db.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+casesdata_table_name);
        db.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+client_table_name);
        db.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+LAW_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+lawyers_table_name);
       // db.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+admin_table_name);
        db.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+references_table_name);
        db.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+user_table_name);
        db.execSQL("DROP TABLE IF EXISTS JD_PROVISION_DB"+SUB_CATEGORY_TABLE);

        onCreate(db);

    }


    //insert categories

    public void insertCategory() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(database.Key_Category_Name, "Civil Laws");db.insert(Category_TABLE_NAME, null, cv);
        cv.put(database.Key_Category_Name, "Female Protection Act");db.insert(Category_TABLE_NAME, null, cv);
        cv.put(database.Key_Category_Name, "Cyber Crimes Act");db.insert(Category_TABLE_NAME, null, cv);
        db.close();
    }


    //cyber laws categorues
    public void addCybercategory(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(CATEGORY_Name,"Cyber"); cv.put(SUB_CATEGORY_Name,"Access to information");
        db.insert(SUB_CATEGORY_TABLE,CATEGORY_Name,cv); //1st
        cv.put(CATEGORY_Name,"Cyber"); cv.put(SUB_CATEGORY_Name,"Hacking");
        db.insert(SUB_CATEGORY_TABLE,CATEGORY_Name,cv); //2nd
        cv.put(CATEGORY_Name,"Cyber"); cv.put(SUB_CATEGORY_Name,"Speech");
        db.insert(SUB_CATEGORY_TABLE,CATEGORY_Name,cv); //3rd
        cv.put(CATEGORY_Name,"Cyber"); cv.put(SUB_CATEGORY_Name,"Spamming");
        db.insert(SUB_CATEGORY_TABLE,CATEGORY_Name,cv); //4th
        cv.put(CATEGORY_Name,"Cyber"); cv.put(SUB_CATEGORY_Name,"Stalking");
        db.insert(SUB_CATEGORY_TABLE,CATEGORY_Name,cv); //5th
        db.close();
    }

    // laws
    // cyber laws
    public void addCyberAct(Context c){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        //1st
        cv.put(LAW_Name,"Unauthorized Acess to information"); cv.put(KEY_Subject,"Unauthorized Access to Information System or Data");
        cv.put(Key_Description,"Law says that if you access any information system or data with dishonest intents");
        cv.put(Key_Panelty,"up to 3 Months Prison or up to Rs. 50,000 Fine or both");
        cv.put(key_Sub_Category,"Access to information");cv.put(Key_Category,"Cyber");
        db.insert(LAW_TABLE_NAME,null,cv);
        //2nd
        cv.put(LAW_Name," Hacking Email/Phone  "); cv.put(KEY_Subject,"Hacking Email / Phone for Stalking");
        cv.put(Key_Description,"If someone monitor a person through mail,text message or" +
                " any other form of electronic communication then you can be jailed.");
        cv.put(Key_Panelty,"jailed for up to 3 years  and a fine of RS. 1 Million or both");
        cv.put(key_Sub_Category,"Hacking");cv.put(Key_Category,"Cyber");
        db.insert(LAW_TABLE_NAME,null,cv);
        //3rd
        cv.put(LAW_Name," Hate Speech "); cv.put(KEY_Subject,"Hate Speech about anything ");
        cv.put(Key_Description," Whoever prepares or distributes information, through any information system or" +
                " device that triggers inter-faith,sectarian or racival hatred, " +
                "shall be punished with imprisoment for a term.");
        cv.put(Key_Panelty,"seven years jail or fine or both ");
        cv.put(key_Sub_Category,"Speech");cv.put(Key_Category,"Cyber");
        db.insert(LAW_TABLE_NAME,null,cv);
        //4th
        cv.put(LAW_Name," Spamming  "); cv.put(KEY_Subject,"Sending spam emails/ messages without reciver permission");
        cv.put(Key_Description,"Sending spam emails / SMS without permission of reciever. " +
                "The process of sending emails without the unsubscribe option." +
                " Sending of emails with illegal informaation, misleading emails, harnful fraudulent emails");
        cv.put(Key_Panelty,"Three months of prison or fine upto 5 Million or both");
        cv.put(key_Sub_Category,"Spamming ");cv.put(Key_Category,"Cyber");
        db.insert(LAW_TABLE_NAME,null,cv);
        //5th
        cv.put(LAW_Name,"Cyber Stalking "); cv.put(KEY_Subject,"Cyber Stalking ");
        cv.put(Key_Description,"If you try to get in a relation with someone online through internet websites, email, SMS, phone or " +
                "any communication tool despitethere is disinterest from other party then you can be jailed.");
        cv.put(Key_Panelty,"jailed for up to three years or imposed fine which may extendto ine million rupees or with both");
        cv.put(key_Sub_Category,"Stalking ");cv.put(Key_Category,"Cyber");
        db.insert(LAW_TABLE_NAME,null,cv);
        db.close();
    }

    //female protectionact categories
    public void addFemaleProtectionActCategories(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(CATEGORY_Name,"FemaleProtectAct");cv.put(SUB_CATEGORY_Name,"False_Information");
        db.insert(SUB_CATEGORY_TABLE,null,cv); //1st
        cv.put(CATEGORY_Name,"FemaleProtectAct");cv.put(SUB_CATEGORY_Name,"Using criminal force");
        db.insert(SUB_CATEGORY_TABLE,null,cv); //2ns
        cv.put(CATEGORY_Name,"FemaleProtectAct");cv.put(SUB_CATEGORY_Name,"Inducing");
        db.insert(SUB_CATEGORY_TABLE,null,cv); //3rd
        cv.put(CATEGORY_Name,"FemaleProtectAct");cv.put(SUB_CATEGORY_Name,"Prostititution");
        db.insert(SUB_CATEGORY_TABLE,null,cv); //4th
        db.close();

    }
    // female protection act
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addFemaleProtectionLaws(Context c){
        SQLiteDatabase db=this.getWritableDatabase();
       // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ContentValues cv=new ContentValues();
        // 1st
        cv.put(LAW_Name," False Information ");cv.put(KEY_Subject,"Spreading False Information about an Individual");
        cv.put(Key_Description,"Whoever intentionally and publicly displays any" +
                " information through any information system,"+
                " which he knows to be false and intimidates or " +
                "harms the reputation or privacy of a natural person.");
        cv.put(Key_Panelty,"up to 3 Years in Prison or up to Rs. 1 Million in Fine or both");
        cv.put(key_Sub_Category,"False Information");cv.put(Key_Category,"FemaleProtectionAct");
        db.insert(LAW_TABLE_NAME,null,cv);
        //2nd
        cv.put(LAW_Name,"inducing woman for marriage");cv.put(Key_Law_Number,"365B");cv.put(KEY_Subject," inducing women for compel marriage");
        cv.put(Key_Description," Whoever kidnaps or abducts any woman with intent that she may be compelled," +
                " or knowing it to be likely that she will be compelled," +
                " to marry any person against her will, or in order that she will be forced.");
        cv.put(Key_Panelty,"imprisoment for life or as aforesaid");
        cv.put(key_Sub_Category,"Inducing");cv.put(Key_Category,"FemaleProtectionAct");
        db.insert(LAW_TABLE_NAME,null,cv);
        //3rd
        cv.put(LAW_Name," Taking of the dress of someone");cv.put(Key_Law_Number,354);cv.put(KEY_Subject,"Taking off the dress of a female uing criminal force");
        cv.put(Key_Description,"If a person ,through the use of criminal force takes  off the dress of a female and he briings such female in public," +
                "thus,tarnish and pollute her modesty.");
        cv.put(Key_Panelty,"The person may get death penalty or imprisoment for life and fine.");
       // cv.put(Key_Date, sdf.format(new Date(System.currentTimeMillis())));
        //cv.put(Key_Date,System.currentTimeMillis());
        cv.put(Key_Date,"2019-07-13");
        cv.put(key_Sub_Category,"Using criminal force");cv.put(Key_Category,"FemaleProtectionAct");
        db.insert(LAW_TABLE_NAME,null,cv);
        //4th
        cv.put(LAW_Name,"Selling person for prostitution ");cv.put(Key_Law_Number,"371A");
        cv.put(Key_Description,"Whoever sells, lets to hire, or otherwise disposes of any person specially females ," +
                "with intent that such person shall at any time be employed or used for the purpose of prostitution or  ");
        cv.put(Key_Panelty,"imprisoned for up to twenty five years or may b  liable to fine");
        cv.put(key_Sub_Category,"Prostititution");cv.put(Key_Category,"FemaleProtectionAct");
        db.insert(LAW_TABLE_NAME,null,cv);
        //5th
        cv.put(LAW_Name," Buying person for the purpose of prostitution ");cv.put(Key_Law_Number,"371B");
        cv.put(Key_Description,"Whoever buys, hires or otherwise obtains possession of any person " +
                "with intent that such person shall at any time" +
                " be employed or used for the purpose of prostitution or");
        cv.put(Key_Panelty,"imprisonment which may extend to twenty-five years, and shall also be liable to fine.");
        cv.put(key_Sub_Category,"Prostititution");cv.put(Key_Category,"FemaleProtectionAct");
        db.insert(LAW_TABLE_NAME,null,cv);
        db.close();
    }

    //civil laws categories
    public void addCivilCategory(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(CATEGORY_Name,"civil"); cv.put(SUB_CATEGORY_Name,"Dishonest Investigation");
        db.insert(SUB_CATEGORY_TABLE,null,cv); //1st
        cv.put(CATEGORY_Name,"civil");cv.put(SUB_CATEGORY_Name,"Offences");
        db.insert(SUB_CATEGORY_TABLE,null,cv); //2ns
        cv.put(CATEGORY_Name,"civil"); cv.put(SUB_CATEGORY_Name,"Unlawful Labour");
        db.insert(SUB_CATEGORY_TABLE,null,cv); // 3rd
        cv.put(CATEGORY_Name,"civil"); cv.put(SUB_CATEGORY_Name,"Fraudulent");
        db.insert(SUB_CATEGORY_TABLE,null,cv); //4th
        cv.put(CATEGORY_Name,"civil");cv.put(SUB_CATEGORY_Name,"Usage of criminal force");
        db.insert(SUB_CATEGORY_TABLE,null,cv); // sth
        db.close();
    }
    // civil laws
    public void addCivilLaws(Context c){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        //first law
        cv.put(LAW_Name," Dishonest or False Investigation ");cv.put(Key_Law_Number,"166B");
        cv.put(KEY_Subject,"Doing false Investigation");
        cv.put(Key_Description,"the court while concluding a trial of any offence will also clearly give findings whether " +
                "unvestigations are done fairly or honestly in accordance to fulfil laws " +
                "all legal and procedural requirements " +
                "neccessary for such investigation or not. ");
        cv.put(Key_Panelty,"up to 3 Years in Prison or up to Rs. 1 Million in Fine or both");
        cv.put(key_Sub_Category,"Dishonest Investigation");cv.put(Key_Category,"CivilLaws");
        db.insert(LAW_TABLE_NAME,null,cv);
        // second
        cv.put(LAW_Name," Unnatural offences ");cv.put(Key_Law_Number,"377");
        cv.put(Key_Description," Whoever voluntarily has carnal intercourse against the order of" +
                "nature with any man, woman or animal");
        cv.put(Key_Panelty,"h imprisonment for life, or" +
                "with imprisonment of either description for a term which shall not be less than two years" +
                "nor more than ten years, and shall also be liable to fine. ");
        cv.put(key_Sub_Category,"Offences");cv.put(Key_Category,"CivilLaws");
        db.insert(LAW_TABLE_NAME,null,cv);
        // third
        cv.put(LAW_Name," Unlawful compulsory labour:");cv.put(Key_Law_Number,"374");
        cv.put(Key_Description," Whoever unlawfully compels any person to labour" +
                "against the will of that person ");
        cv.put(Key_Panelty," imprisonment of either description" +
                "for a term which may extend to 1 [five] years or with fine, or with both");
        cv.put(key_Sub_Category,"Unlawful Labour");cv.put(Key_Category,"CivilLaws");
        db.insert(LAW_TABLE_NAME,null,cv);
        // forth
        cv.put(LAW_Name,"  Fraudulent use of false instrument for weighing ");cv.put(Key_Law_Number,"264");
        cv.put(Key_Description,"  Whoever fraudulently uses any" +
                "instrument for weighing which he knows to be false,");
        cv.put(Key_Panelty," imprisonment of either description for a term, which may extend to one year, or with fine, or with both. ");
        cv.put(key_Sub_Category,"Fraudulent");cv.put(Key_Category,"CivilLaws");
        db.insert(LAW_TABLE_NAME,null,cv);
        // fifth
        cv.put(LAW_Name," Use of Criminal Force ");cv.put(Key_Law_Number,"352");
        cv.put(KEY_Subject,"Use of criminal force or assult " +
                "expect under the influence of severe provocation ");
        cv.put(Key_Description,"When a person commits the act of usage criminal force or assult, provided" +
                " that he is not severely provoked to act so, " +
                "the person commmmitting so may receive imprisoment. ");
        cv.put(Key_Panelty,"imprisoment for three months  or fine upto fifteen hundred rupees or both ");
        cv.put(key_Sub_Category,"Usage of criminal force");cv.put(Key_Category,"CivilLaws");
        db.insert(LAW_TABLE_NAME,null,cv);
        // Toast.makeText(c, "Data is inserted", Toast.LENGTH_SHORT).show();
        db.close();
    }

}
