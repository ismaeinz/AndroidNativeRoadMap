انا كان عندي داتا موجوده في الوقت الحالي او جيه نتيجه كونفجريشن حصل او حدث حصل بقول عليها state  المشكله في الـstate ان مع كل كوفجريشن بتحصل كانت للاسف بتضيع مني بفقدها حرفيا فانا محتاج اهندلها مش احفظها اهندلها بمعني احفظهابشكل مؤقت 
ومحتاج كمان الـstate دي تستجيب لل بيحصل للـui 
فظهر معايا أول حاجه الـremember هو بيحفظ الـstate والدنيا تمام بس اكتشفت انه مع كل كونفجريشن زي اني اعمل روتيت للـscreen الـstate بتضيع مني 
فظهر حل تاني وهو الـrememberSeavable كان حل كويس وتمام وبيحفظ الـstate لفتره معينه 
بس ده كله كلام أنا عايز حاجه اعم واشمل وهنا ظهر الـviewModel وهي ببساطه مستودع بيحفظ الـstate علي طول حاله التطبيق 
//الـactivity عباره عن view
//الـlayout التصميم ال بيتحط علي الـview
//الـactivity ليها دوره حياه
//الـviewModel بكل بساطه اتعمل عشان يهحافظ ع الـstate في حالات الكونفجريشن
//انت محتاج تفهم حاجتين يعني اي state وازاي تجمعها
//الـcontext عباره عن الـbridge بين الابلكيشن بتاعك والـos
//الـthis تعبر عن الـobject الموجوده داخله


        //        Toast.makeText(this, "text", Toast.LENGTH_SHORT).show()

//        Toast.makeText(baseContext, "text", Toast.LENGTH_SHORT).show()
//بيجيب الـcontext بتاع العنصر الموجود داخله الـbaseContext
//        Toast.makeText(applicationContext, "text", Toast.LENGTH_SHORT).show()
//الـapplicationContext بيجيب الـcontext بتاع الابلكيشن كله
//الـintent عباره عن وسيله تواصل بين مكونات التطبيق
//        الـexplicitIntent لو حددت مباشره مكان الانتقال
//        استخدامه في التنقل بين الـactivity وتشغيل الـservices وبيستقبل الـbroadcast وتمرير البيانات

//val context = LocalContext.current
