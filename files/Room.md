اولا الـEntity عباره عن جدول الداتبيز
ثانيا الـDao عباره عن انترفيس فيه الـميثود ال بتتفاعل مع الداتابيز
ثالثا الـDatabase عباره عن ابستراكت كلاس بعرف فيه الداتابيز بتاعتي 

 
abstract class NameDb:RoomDatabase(){
abstract fun getphotoDao: Dao
}

الـSharedPreferences طريقه تخزين علي شكل كي اند فاليو عندنا حاجه زي الـcollectionMap بخزن فيه حاجات بسيطه زي الـMode زي اذا كان login او لا


ولكن جوجل بتروكمنتيشن انك تستخدم الـDataStore :
http://developer.android.com/training/data-storage/shared-preferences
الـDataStore
عندي طريقتين للـDataStore

https://www.youtube.com/watch?v=5pjdE2wnJ0s&list=LL&index=4&t=124s&ab_channel=AhmedGuedmioui

الديباندسي 
بعدين الـentity

بعدين الـDao : ده ال عمليات ال بعملها علي الـDatabase
بعدين بنعمل الـDataBase:

abstract class NameDb:RoomDatabase(){
abstract fun getphotoDao: Dao
}
