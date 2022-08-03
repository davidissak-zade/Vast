package com.example.eskillsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ImageButton searchButton, HomeButton, DiscussionsButton, BankAccount, Renting, License, CV, scholarship
     ,visa;
    TextView cvtxt,scholtxt,interviewtxt, examtxt,unitxt, banktxt,visatxt, savingtxt,loantxt, billtxt, taxestxt,licensetxt, renttxt, insuracetxt, cartxt,mailtxt,laundrytxt, WelcomeTXT, Section1TXT, Section2TXT, Section3TXT;


    private String PageID;
    private Object AdapterView;
    String Language = "ENG";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int max = 9;
        int min = 1;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;

        TextView message;
        message = findViewById(R.id.message);

        String[] quoteStr = {"We cannot solve problems with the kind of thinking we employed when we came up with them.” — Albert Einstein};", "Goal setting is the secret to a compelling future.” — Tony Robbins", "Learn as if you will live forever, live like you will die tomorrow", "It is never too late to be what you might have been.", "When you change your thoughts, remember to also change your world.", "Success is not final; failure is not fatal: It is the courage to continue that counts.", "Success usually comes to those who are too busy looking for it.", "I never dreamed about success. I worked for it", "Success is getting what you want, happiness is wanting what you get."};
        String[] quoteStrArb={"خلف الصبر أشياء جميلة، فأنتظر", "إدفع نفسك بنفسك", "لا تنتظر الفرصة، إصنعها", "لا تستسلم على اللإطلاق، الأشياء الجميلة تأخذ وقتاً فكن صبوراً", "كلما عملت بجد من أجل شيء ما، زادت سعادتك عند تحققه", "ليس هناك تحدٍ أكبر من تحسين ذاتك وتطويرها.", "مفتاح الحياة هو عدم الاستسلام عندما تشعر بالضعف.", "أعظم النجاحات تأتي بعد أشق العثرات.", "ليس هناك اسرار للنجاح، فهو حصيلة الاعداد الجيد، والعمل الشاق، والتعلم من الأخطاء والفشل."};
        String[] quoteStrHeb={"האדם שמזיז הרים, התחיל בלסחוב אבנים קטנות", "מי שלא מוכן לטעות, לעולם לא יגיע למשהו מקורי", "אני מאמין גדול במזל, ושמתי לב שככל שאני עובד קשה יותר, יש לי יותר מזל", "אדם חייב להיות מוכן לוותר על מי שהוא, כדי להפוך למי שהוא יכול להיות", "אנשים אומרים שמוטיבציה לא מחזיקה הרבה זמן. גם מקלחת לא, לכן אנו ממליצים אותה על בסיס יומי", "כשהם אומרים לך שאתה לא יכול, הם מראים לך את הגבולות שלהם, לא שלך", "אנשים מסוימים ישנאו אותך על היותך שונה, אבל בפנים הם מייחלים שיהיה להם אומץ לעשות אותו הדבר", "אתה תמיד גדול כגודל העניין שאתה משרת ואתה נהייה קטן אם אתה משרת רק את עצמך"," אומץ הוא לא תמיד שאגה, לפעמים אומץ הוא קול חלוש בסוף היום שאומר - מחר אנסה פעם נוספת" ,"מי שמפחד להסתכן, מסתכן בחיים של בינוניות"};
        message.setText(quoteStr[rand-1]);

        Spinner mySpinner = findViewById(R.id.spinner1);
        String[] items = new String[]{"ENG", "ARB", "HEB"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mySpinner.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int i, long id) {
                Log.d("INDENT", ""+i);
                if (i == 0){
                            mySpinner.setOnItemSelectedListener(this);
                            WelcomeTXT.setText(R.string.introENG);
                            Section1TXT.setText(R.string.Section1ENG);
                            cvtxt.setText(R.string.CVENG);
                            scholtxt.setText(R.string.ScholarshipsENG);
                            interviewtxt.setText(R.string.InterviewENG);
                            examtxt.setText(R.string.PsychometryENG);
                            unitxt.setText(R.string.UniversityENG);

                            Section2TXT.setText(R.string.Section2ENG);
                            banktxt.setText(R.string.BankENG);
                            visatxt.setText(R.string.VisaENG);
                            savingtxt.setText(R.string.SavingsENG);
                            loantxt.setText(R.string.LoansENG);
                            billtxt.setText(R.string.BillsENG);
                            taxestxt.setText(R.string.TaxesENG);

                            Section3TXT.setText(R.string.Section3ENG);
                            licensetxt.setText(R.string.LicenseENG);
                            renttxt.setText(R.string.RentENG);
                            insuracetxt.setText(R.string.InsuranceENG);
                            cartxt.setText(R.string.CarENG);
                            mailtxt.setText(R.string.MailingENG);
                            laundrytxt.setText(R.string.LaundryENG);

                            message.setText(quoteStr[rand-1]);


                         }
                else if(i == 1) {
                                    Language = "ARB";
                                    WelcomeTXT.setText(R.string.introARB);
                                    Section1TXT.setText(R.string.Section1ARB);
                                    cvtxt.setText(R.string.CVARB);
                                    scholtxt.setText(R.string.ScholarshipsARB);
                                    interviewtxt.setText(R.string.InterviewARB);
                                    examtxt.setText(R.string.PsychometryARB);
                                    unitxt.setText(R.string.UniversityARB);

                                    Section2TXT.setText(R.string.Section2ARB);
                                    banktxt.setText(R.string.BankARB);
                                    visatxt.setText(R.string.VisaARB);
                                    savingtxt.setText(R.string.SavingsARB);
                                    loantxt.setText(R.string.LoansARB);
                                    billtxt.setText(R.string.BillsARB);
                                    taxestxt.setText(R.string.TaxesARB);

                                    Section3TXT.setText(R.string.Section3ARB);
                                    licensetxt.setText(R.string.LicenseARB);
                                    renttxt.setText(R.string.RentARB);
                                    insuracetxt.setText(R.string.InsuranceARB);
                                    cartxt.setText(R.string.CarARB);
                                    mailtxt.setText(R.string.MailingARB);
                                    laundrytxt.setText(R.string.LaundryARB);

                                    message.setText(quoteStrArb[rand-1]);
                                }

                else if(i ==2)  {
                                    Language = "HEB";
                                    WelcomeTXT.setText(R.string.introHEB);
                                    Section1TXT.setText(R.string.Section1HEB);
                                    cvtxt.setText(R.string.CVHEB);
                                    scholtxt.setText(R.string.ScholarshipsHEB);
                                    interviewtxt.setText(R.string.InterviewHEB);
                                    examtxt.setText(R.string.PsychometryHEB);
                                    unitxt.setText(R.string.UniversityHEB);

                                    Section2TXT.setText(R.string.Section2HEB);
                                    banktxt.setText(R.string.BankHEB);
                                    visatxt.setText(R.string.VisaHEB);
                                    savingtxt.setText(R.string.SavingsHEB);
                                    loantxt.setText(R.string.LoansHEB);
                                    billtxt.setText(R.string.BillsHEB);
                                    taxestxt.setText(R.string.TaxesHEB);

                                    Section3TXT.setText(R.string.Section3HEB);
                                    licensetxt.setText(R.string.LicenseHEB);
                                    renttxt.setText(R.string.RentHEB);
                                    insuracetxt.setText(R.string.InsuranceHEB);
                                    cartxt.setText(R.string.CarHEB);
                                    mailtxt.setText(R.string.MailingHEB);
                                    laundrytxt.setText(R.string.LaundryHEB);

                                    message.setText(quoteStrHeb[rand-1]);
                                }
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {

            }
        });

        // binding the text holders
        WelcomeTXT = findViewById(R.id.welcome);
        Section1TXT = findViewById(R.id.section1);
        Section2TXT = findViewById(R.id.section2);
        Section3TXT = findViewById(R.id.section3);
        cvtxt = findViewById(R.id.cvtxt);
        scholtxt = findViewById(R.id.scholtxt);
        interviewtxt = findViewById(R.id.interviewtxt);
        examtxt= findViewById(R.id.examtxt);
        unitxt= findViewById(R.id.unitxt);
        banktxt = findViewById(R.id.banktxt);
        visatxt= findViewById(R.id.visatxt);
        savingtxt= findViewById(R.id.savingtxt);
        loantxt = findViewById(R.id.loantxt);
        billtxt = findViewById(R.id.billtxt);
        taxestxt = findViewById(R.id.taxestxt);
        licensetxt = findViewById(R.id.licensetxt);
        renttxt = findViewById(R.id.renttxt);
        insuracetxt = findViewById(R.id.insuracetxt);
        cartxt = findViewById(R.id.cartxt);
        mailtxt = findViewById(R.id.mailtxt);
        laundrytxt = findViewById(R.id.laundrytxt);

        searchButton = findViewById(R.id.searchbutton);
        DiscussionsButton = findViewById(R.id.DiscussionsButton);
        HomeButton = findViewById(R.id.HomeButton);
        BankAccount = findViewById(R.id.bankaccount);
        Renting = findViewById(R.id.renting);
        License = findViewById(R.id.license);
        CV = findViewById(R.id.CV);
        scholarship  = findViewById(R.id.scholarship );
        visa  = findViewById(R.id.visa );


        DiscussionsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, MemberCommunityActivity.class));
            }
        });

        HomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, MemberCommunityActivity.class));
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SearchBarActivity.class));
            }
        });

        Renting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, cvView.class);
                PageID = "1";
                i.putExtra("PageID", PageID);
                i.putExtra("PageLanguage", Language);

                startActivity(i);
            }
        });


        BankAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, cvView.class);
                PageID = "3";
                i.putExtra("PageID", PageID);
                i.putExtra("PageLanguage", Language);
                startActivity(i);
            }
        });


        License.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, cvView.class);;
                PageID = "2";
                i.putExtra("PageID", PageID);
                i.putExtra("PageLanguage", Language);
                startActivity(i);
            }
        });

        CV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, cvView.class);;
                PageID = "4";
                i.putExtra("PageID", PageID);
                i.putExtra("PageLanguage", Language);
                startActivity(i);
            }
        });

        scholarship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, cvView.class);;
                PageID = "5";
                i.putExtra("PageID", PageID);
                i.putExtra("PageLanguage", Language);
                startActivity(i);
            }
        });

        visa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, cvView.class);;
                PageID = "6";
                i.putExtra("PageID", PageID);
                i.putExtra("PageLanguage", Language);
                startActivity(i);
            }
        });

    }
}