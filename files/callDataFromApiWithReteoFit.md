اولا  : تروح تعمل الاترفيس

interface GymsApiServices {
@GET("gyms.json") //endPoints
fun getGyms(): Call<List<Gym>>
}


ثانيا :تهندل الريسبونس في شكل داتا كلا
data class Gym(
val id: Int,
@SerializedName("gym_name")
val name: String,
@SerializedName("gym_location")
val place: String,
var isFavourite: Boolean = false,
)

ثالثا :تروح تظبط الفيو مودل
class GymsViewModel(
private val stateHandle: SavedStateHandle,
) : ViewModel(

) {

var state by mutableStateOf(emptyList<Gym>())

private var apiServices: GymsApiServices
private lateinit var gymsCall:Call<List<Gym>>

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory
                    .create()
            )
            .baseUrl(
                "https://cairo-gyms-f29c8-default-rtdb.firebaseio.com/"
            ).build()
        apiServices = retrofit.create(GymsApiServices::class.java)
<!--         call Function -->
        getGyms()
    }

    private fun getGyms() {
    
        gymsCall = apiServices.getGyms()
        gymsCall.enqueue(
<!--     في حاله ان الاكتيفيتي اتعمل ليه ديستروي لاي سبب والريسبونس لسه مرجعش الاوبجكت هيفضل موجود في الموموري والكاربدج كولكتور مش هيعرف يفضي الموموري فالحل اننا نعمله بنفسنا     -->
        object : Callback<List<Gym>> {
<!--     enqueue to make response on background thread     -->
            override fun onResponse(
                call: Call<List<Gym>>,
                response:
                Response<List<Gym>>,
            ) {
                response.body()?.let {
                    state = it
                }
            }

            override fun onFailure
            (call: Call<List<Gym>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

    override fun onCleared() {
        super.onCleared()
        gymsCall.cancel()
    }



حامسا :تعرض الداتا

val vmGyms: GymsViewModel = viewModel()
LazyColumn {
items(vmGyms.state) { gym ->
GymItem(gym) { gymId ->
vmGyms.toggleFavouriteState(gymId)
}
}

    }

}
