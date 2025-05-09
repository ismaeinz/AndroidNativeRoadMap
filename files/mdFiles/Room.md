اولا الـEntity عباره عن جدول الداتبيز
ثانيا الـDao عباره عن انترفيس فيه الـميثود ال بتتفاعل مع الداتابيز
ثالثا الـDatabase عباره عن ابستراكت كلاس بعرف فيه الداتابيز بتاعتي 

 
abstract class MyDb:RoomDatabase(){
عشان اربط الـdao بالـdatabase
abstract val dao: Dao
عشان اقد ااكسس الـDatabase من غير ما اعمل instance منها 
componponion object{
هتسمح للفاريبول انه يكون متاح في الـthreads التانيه
@Volatile
بعمل فانكشن بتجيت الـdao
private var daoInstance:Dao?=null
private fun buidDataBase(context:Context):MyDb= Room.DatabaseBuilder(context.applicationContext,MyDb::class.java,"NameOfDb").build()
fun getDaoInstance(context:Context):Dao{

الـsynchronized عشان مايكونش عندنا اكتر من ريفرانسيس للـdatabse

synchronized(this){
if(daoInstance==null){
daoInstance=buidDataBase(context).dao
}
return daoInstance as Dao
}
}
}
}
<!--  -->

الـgetDaoInstance بتحتاج context وانا محتاج استخدمها في الـviewModel
class MyApplication:Application(){

init{
application:this
}
componponion object{
private lateinit var application:MyApplication
fun getApplicationContext():Context=application.applicationContext
}
}



<!--  -->
في الـviewModel
private val dao=MyDb.getDaoInstance(MyApplication.getApplicationContext())


<!--  -->


الـSharedPreferences طريقه تخزين علي شكل كي اند فاليو عندنا حاجه زي الـcollectionMap بخزن فيه حاجات بسيطه زي الـMode زي اذا كان login او لا


ولكن جوجل بتروكمنتيشن انك تستخدم الـDataStore :
http://developer.android.com/training/data-storage/shared-preferences
الـDataStore
عندي طريقتين للـDataStore

https://www.youtube.com/watch?v=5pjdE2wnJ0s&list=LL&index=4&t=124s&ab_channel=AhmedGuedmioui

