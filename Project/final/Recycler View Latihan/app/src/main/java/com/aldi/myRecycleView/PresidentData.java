package com.aldi.myRecycleView;

import java.util.ArrayList;

public class PresidentData {
    public static String[][] data = new String[][]{
            {"Christ the Redeeme", "Brasil", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Redentor.jpg/220px-Redentor.jpg","Christ the Redeemer atau Patung Kristus Penebus adalah sebuah Patung Yesus yang berada di atas gunung Corcovado Kota Rio de Janeiro, Brasil. Patung Yesus ini memiliki ketinggian sekitar 38 meter dan memerlukan 5 tahun untuk menyelesaikannya","12 Oktober 1931"},
            {"The Great Wall", "China", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Great_Wall_of_China.jpeg/250px-Great_Wall_of_China.jpeg","The Great Wall of China atau Tembok Besar China (ada juga yang menyebutnya Tembok Raksasa China) adalah sebuah Tembok besar yang dibangun untuk menghubungkan benteng-benteng pertahanan dengan tujuan untuk  melindungi wilayah China dari penyerangan suku Mongol.","1655"},
            {"Machu Picchu", "Peru", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/80_-_Machu_Picchu_-_Juin_2009_-_edit.2.jpg/300px-80_-_Machu_Picchu_-_Juin_2009_-_edit.2.jpg","Machu Picchu adalah reruntuhan Inka yang terletak di wilayah lembah penggunungan Urubamba, Peru.   Machu Picchu merupakan sebuah kota yang dibangun pada tahun 1450 oleh kerajaan Inka , tetapi ditinggalkan seratus tahun kemudian ketika Kerajaan Inka ditaklukan oleh bangsa Spanyol.","1450"},
            {"Petra", "Yordania", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Al_Khazneh.jpg/290px-Al_Khazneh.jpg","Petra adalah sebuah kota yang didirikan dengan ukiran dinding-dinding pada tebing berbatu di Yordania"," 9 SM hingga tahun 40 M"},
            {"Pyramid at Chichén Itzá", "Meksiko", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/Chichen-Itza-Castillo-Seen-From-East.JPG/250px-Chichen-Itza-Castillo-Seen-From-East.JPG","Pyramid at Chichén Itzá adalah sebuah bangunan yang berbentuk Piramida dan dipercayai sebagai pusat kegiatan politik dan ekonomi bangsa Maya yang terletak di Semenanjung Yucatan Meksiko.  Di sekitar Chichen Itza terdapat beberapa bangunan seperti Piramida Kulkucan, Candi Chac Mool, dan bangunan seribu tiang.","800 SM"},
            {" Roman Colosseum", "Roma Italia", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/COLOSSEUM.JPG/240px-COLOSSEUM.JPG","Roman Colosseum merupakan sebuah bangunan yang diperuntukkan sebagai tempat penyelenggaran pertunjukan yang spektakuler seperti pertarungan antara binatang, pertarungan antara tahanan dan binatang serta pertarungan gladiator.","72 M"},
            {"Taj Mahal Agra", "India", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Taj_Mahal_in_March_2004.jpg/250px-Taj_Mahal_in_March_2004.jpg","aj Mahal merupakan sebuah Monumen yang didirikan oleh Kaisar Mughal kelima yang bernama Shah Jahan untuk mengenang istri tercintanya Mumtaz Mahal yang wafat saat melahirkan putrinya Gauhara Begum (anak mereka yang ke-14). Monumen yang terletak di Agra India ini merupakan sebuah adi karya arsitektur Mughal yang dibangun pada tahun 1630 dan selesai pada tahun 1653","1630-1653 M"}
    };
    public static ArrayList<President> getListData(){
        President president = null;
        ArrayList<President> list = new ArrayList<>();
        for (String[] aData : data) {
            president = new President();
            president.setName(aData[0]);
            president.setRemarks(aData[1]);
            president.setPhoto(aData[2]);
            president.setDetail(aData[3]);
            president.setDibuat(aData[4]);


            list.add(president);
        }

        return list;
    }
}
