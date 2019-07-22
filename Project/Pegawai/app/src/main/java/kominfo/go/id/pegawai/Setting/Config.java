package kominfo.go.id.pegawai.Setting;

public class Config {

    public static final String BASE_URL = "https://officialdevbjb.com/digitalent/";    //Online URL
    public static final String ACTIVE_URL = BASE_URL;//"http://192.168.12.1/digitalent/";    //Offline URL

    public static final String URL_ADD = ACTIVE_URL + "tambahpgw";
    public static final String URL_GET_ALL = ACTIVE_URL + "tampilsemua";
    public static final String URL_GET_EMP = ACTIVE_URL + "tampilpgw?id=";
    public static final String URL_UPDATE_EMP = ACTIVE_URL + "updatepgw";
    public static final String URL_DELETE_EMP = ACTIVE_URL + "hapuspgw?id=";


    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAMA = "name";
    public static final String KEY_EMP_POSISI = "position";
    public static final String KEY_EMP_GAJIH = "salary";

    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "name";
    public static final String TAG_POSISI = "position";
    public static final String TAG_GAJIH = "salary";

    public static final String EMP_ID = "emp_id";
}
