اولا الـEntity عباره عن جدول الداتبيز
ثانيا الـDao عباره عن انترفيس فيه الـميثود ال بتتفاعل مع الداتابيز
ثالثا الـDatabase عباره عن ابستراكت كلاس بعرف فيه الداتابيز بتاعتي 

 
abstract class NameDb:RoomDatabase(){
abstract fun getphotoDao: Dao
}
