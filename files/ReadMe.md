

companion object{
خاصيه مشنتركه بين كل الاوبجكتات من هذا النوع ونقدر نعدل عليها 
في لغات االبرمجه الاخري نستخدم ستاتيك
وكمان تقدر تصل ليه من غير ما تعمل اوبجكت من الكلاس 
}


init{
}
extintionFunction
ال enum كلاس عباره ع كلاس بياخد حاجات ثابته
Enum() 
enum class x {
y,zz}
=> x.y
=>x.z
=>var m:x=x.y

[//]: # ()
fun main() {
namePrint("ismaein",28)


}

fun <T> namePrint(name:T,age:Int){
print(name )
print(age )
}

[//]: # ()
apply
let{}
بستخدمها في حاله الفحص لو متغير راجع ومش عارف قيمته هتكون ازاي ؟
مثال
x?.name=....
x?.ccc=...
x?.let{
it.name,
it.ccc
}

[//]: # ()
with

var content:String?=null
lateinit var content:String
بستخدمها للتعريف وبعدين هتديها قيمه 


