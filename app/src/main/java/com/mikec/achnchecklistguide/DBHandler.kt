package com.mikec.achnchecklistguide;


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(val context: Context) : SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION){
    override fun onCreate(db: SQLiteDatabase) {
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun createTables(){
        val db: SQLiteDatabase = writableDatabase
        val createFossilTable:String = "CREATE TABLE $TABLE_FOSSILS (" +
                "$FCOL_ID integer PRIMARY KEY," +
                "$FCOL_NAME varchar," +
                "$FCOL_IMAGE varchar," +
                "$FCOL_SELLPRICE integer," +
                "$FCOL_DONATED integer DEFAULT 0," +
                "hemisphere integer DEFAULT 0);"

        val insertFossilStatement: String = "INSERT INTO $TABLE_FOSSILS (" +
                "$FCOL_ID, $FCOL_NAME, $FCOL_IMAGE, $FCOL_SELLPRICE, $FCOL_DONATED) VALUES "+
                "(null,\"Acanthostega\",\"acanthostega.png\",2000,0)," +
                "(null,\"Amber\",\"amber.png\",1200,0)," +
                "(null,\"Ammonite\",\"ammonite.png\",1100,0)," +
                "(null,\"Ankylo skull\",\"ankyloskull.png\",5000,0)," +
                "(null,\"Ankylo tail\",\"ankylotail.png\",2500,0)," +
                "(null,\"Ankylo torso\",\"ankylotorso.png\",3000,0)," +
                "(null,\"Anomalocaris\",\"anomalocaris.png\",2000,0)," +
                "(null,\"Archaeopteryx\",\"archaeopteryx.png\",1300,0)," +
                "(null,\"Archelon skull\",\"archelonskull.png\",4000,0)," +
                "(null,\"Archelon tail\",\"archelontail.png\",3500,0)," +
                "(null,\"Australopith\",\"australopith.png\",1100,0)," +
                "(null,\"Brachio chest\",\"brachiochest.png\",5500,0)," +
                "(null,\"Brachio pelvis\",\"brachiopelvis.png\",5000,0)," +
                "(null,\"Brachio skull\",\"brachioskull.png\",6000,0)," +
                "(null,\"Brachio tail\",\"brachiotail.png\",5500,0)," +
                "(null,\"Coprolite\",\"coprolite.png\",1100,0)," +
                "(null,\"Deinony tail\",\"deinonytail.png\",2500,0)," +
                "(null,\"Deinony torso\",\"deinonytorso.png\",3000,0)," +
                "(null,\"Dimetrodon skull\",\"dimetrodonskull.png\",5500,0)," +
                "(null,\"Dimetrodon torso\",\"dimetrodontorso.png\",5000,0)," +
                "(null,\"Dinosaur track\",\"dinosaurtrack.png\",1000,0)," +
                "(null,\"Diplo chest\",\"diplochest.png\",4000,0)," +
                "(null,\"Diplo neck\",\"diploneck.png\",4500,0)," +
                "(null,\"Diplo pelvis\",\"diplopelvis.png\",4500,0)," +
                "(null,\"Diplo skull\",\"diploskull.png\",5000,0)," +
                "(null,\"Diplo tail tip\",\"diplotailtip.png\",4000,0)," +
                "(null,\"Diplo tail\",\"diplotail.png\",5000,0)," +
                "(null,\"Dunkleosteus\",\"dunkleosteus.png\",3500,0)," +
                "(null,\"Eusthenopteron\",\"eusthenopteron.png\",2000,0)," +
                "(null,\"Iguanodon skull\",\"iguanodonskull.png\",4000,0)," +
                "(null,\"Iguanodon tail\",\"iguanodontail.png\",3000,0)," +
                "(null,\"Iguanodon torso\",\"iguanodontorso.png\",3500,0)," +
                "(null,\"Juramaia\",\"juramaia.png\",1000,0)," +
                "(null,\"Left megalo side\",\"leftmegaloside.png\",4000,0)," +
                "(null,\"Left ptera wing\",\"leftpterawing.png\",4500,0)," +
                "(null,\"Left quetzal wing\",\"leftquetzalwing.png\",5000,0)," +
                "(null,\"Mammoth skull\",\"mammothskull.png\",3000,0)," +
                "(null,\"Mammoth torso\",\"mammothtorso.png\",2500,0)," +
                "(null,\"Megacero skull\",\"megaceroskull.png\",4500,0)," +
                "(null,\"Megacero tail\",\"megacerotail.png\",3000,0)," +
                "(null,\"Megacero torso\",\"megacerotorso.png\",3500,0)," +
                "(null,\"Myllokunmingia\",\"myllokunmingia.png\",1500,0)," +
                "(null,\"Ophthalmo skull\",\"ophthalmoskull.png\",2500,0)," +
                "(null,\"Ophthalmo torso\",\"ophthalmotorso.png\",2000,0)," +
                "(null,\"Pachysaurus skull\",\"pachysaurusskull.png\",4000,0)," +
                "(null,\"Pachysaurus tail\",\"pachysaurustail.png\",3500,0)," +
                "(null,\"Parasaur skull\",\"parasaurskull.png\",3500,0)," +
                "(null,\"Parasaur tail\",\"parasaurtail.png\",2500,0)," +
                "(null,\"Parasaur torso\",\"parasaurtorso.png\",3000,0)," +
                "(null,\"Plesio body\",\"plesiobody.png\",4500,0)," +
                "(null,\"Plesio skull\",\"plesioskull.png\",4000,0)," +
                "(null,\"Plesio tail\",\"plesioneck.png\",4500,0)," +
                "(null,\"Ptera body\",\"pterabody.png\",4000,0)," +
                "(null,\"Quetzal torso\",\"quetzaltorso.png\",4500,0)," +
                "(null,\"Right megalo side\",\"rightmegaloside.png\",5500,0)," +
                "(null,\"Right ptera wing\",\"rightpterawing.png\",4500,0)," +
                "(null,\"Right quetzal wing\",\"rightquetzalwing.png\",5000,0)," +
                "(null,\"Sabertooth skull\",\"sabertoothskull.png\",2500,0)," +
                "(null,\"Sabertooth tail\",\"sabertoothtail.png\",2000,0)," +
                "(null,\"Shark-tooth pattern\",\"sharktoothpattern.png\",1000,0)," +
                "(null,\"Spino skull\",\"spinoskull.png\",4000,0)," +
                "(null,\"Spino tail\",\"spinotail.png\",4000,0)," +
                "(null,\"Spino torso\",\"spinotorso.png\",5000,0)," +
                "(null,\"Stego skull\",\"stegoskull.png\",5000,0)," +
                "(null,\"Stego tail\",\"stegotail.png\",4000,0)," +
                "(null,\"Stego torso\",\"stegotorso.png\",4500,0)," +
                "(null,\"T. rex skull\",\"trexskull.png\",6000,0)," +
                "(null,\"T. rex tail\",\"trextail.png\",5000 ,0), " +
                "(null,\"T. rex torso\",\"trextorso.png\",5500,0)," +
                "(null,\"Tricera skull\",\"triceraskull.png\",5500,0)," +
                "(null,\"Tricera tail\",\"triceratail.png\",4500,0)," +
                "(null,\"Tricera torso\",\"triceratorso.png\",5000,0)," +
                "(null,\"Trilobite\",\"trilobite.png\",1300,0);"

        val createFishTable:String = "CREATE TABLE Fish (id integer PRIMARY KEY," +
                "name varchar," +
                "image varchar," +
                "price integer," +
                "donated integer," +
                "location varchar," +
                "shadow varchar," +
                "time varchar," +
                "nJan integer," +
                "nFeb integer," +
                "nMar integer," +
                "nApr integer," +
                "nMay integer," +
                "nJun integer," +
                "nJul integer," +
                "nAug integer," +
                "nSep integer," +
                "nOct integer," +
                "nNov integer," +
                "nDec integer," +
                "sJan integer," +
                "sFeb integer," +
                "sMar integer," +
                "sApr integer," +
                "sMay integer," +
                "sJun integer," +
                "sJul integer," +
                "sAug integer," +
                "sSep integer," +
                "sOct integer," +
                "sNov integer," +
                "sDec integer," +
                "hemisphere integer DEFAULT 0);"

        val insertFishStatement: String = "INSERT INTO Fish (id,name,image,price,donated,location,shadow,time,nJan,nFeb,nMar,nApr,nMay, " +
                "nJun,nJul,nAug,nSep,nOct,nNov,nDec,sJan,sFeb,sMar,sApr,sMay,sJun,sJul,sAug,sSep,sOct,sNov,sDec) VALUES " +
                "(null,\"Anchovy\",\"anchovy.png\",200,0,\"Sea\",\"Small\",\"4 AM - 9 PM\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Angelfish\",\"angelfish.png\",3000,0,\"River\",\"Small\",\"4 PM - 9 AM\",0,0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,0,1,1), " +
                "(null,\"Arapaima\",\"arapaima.png\",10000,0,\"River\",\"Huge\",\"4 PM - 9 AM\",0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1), " +
                "(null,\"Arowana\",\"arowana.png\",10000,0,\"River\",\"Large\",\"4 PM - 9 AM\",0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1), " +
                "(null,\"Barred knifejaw\",\"barredknifejaw.png\",5000,0,\"Sea\",\"Medium\",\"All day\",0,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,0,1,1,1,1), " +
                "(null,\"Barreleye\",\"barreleye.png\",15000,0,\"Sea\",\"Small\",\"9 PM - 4 AM\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Betta\",\"betta.png\",2500,0,\"River\",\"Small\",\"9 AM - 4 PM\",0,0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,0,1,1), " +
                "(null,\"Bitterling\",\"bitterling.png\",900,0,\"River\",\"Tiny\",\"All day\",1,1,1,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,1,1,1,0,0,0), " +
                "(null,\"Black bass\",\"blackbass.png\",400,0,\"River\",\"Large\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Blowfish\",\"blowfish.png\",5000,0,\"Sea\",\"Medium\",\"9 PM - 4 AM\",1,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,1,1,0,0,0,0), " +
                "(null,\"Blue marlin\",\"bluegill.png\",10000,0,\"Pier\",\"Huge\",\"All day\",1,1,1,1,0,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,0), " +
                "(null,\"Bluegill\",\"bluemarlin.png\",180,0,\"River\",\"Small\",\"9 AM - 4 PM\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Butterfly fish\",\"butterflyfish.png\",1000,0,\"Sea\",\"Small\",\"All day\",0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1), " +
                "(null,\"Carp\",\"carp.png\",300,0,\"Pond\",\"Large\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Catfish\",\"catfish.png\",800,0,\"Pond\",\"Large\",\"4 PM - 9 AM\",0,0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,0,1,1), " +
                "(null,\"Char\",\"char.png\",3800,0,\"River (Clifftop) Pond\",\"Medium\",\"4 PM - 9 AM\",0,0,1,1,1,1,0,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1,1,1), " +
                "(null,\"Cherry salmon\",\"cherrysalmon.png\",800,0,\"River (Clifftop)\",\"Medium\",\"4 PM - 9 AM\",0,0,1,1,1,1,0,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1,1,1), " +
                "(null,\"Clown fish\",\"clownfish.png\",650,0,\"Sea\",\"Tiny\",\"All day\",0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1), " +
                "(null,\"Coelacanth\",\"coelacanth.png\",15000,0,\"Sea (while raining)\",\"Huge\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Crawfish\",\"crawfish.png\",200,0,\"Pond\",\"Small\",\"All day\",0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1), " +
                "(null,\"Crucian carp\",\"cruciancarp.png\",160,0,\"River\",\"Small\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Dab\",\"dab.png\",300,0,\"Sea\",\"Medium\",\"All day\",1,1,1,1,0,0,0,0,0,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0), " +
                "(null,\"Dace\",\"dace.png\",240,0,\"River\",\"Medium\",\"4 PM - 9 AM\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Dorado\",\"dorado.png\",15000,0,\"River\",\"Very Large\",\"4 AM - 9 PM\",0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1), " +
                "(null,\"Football fish\",\"footballfish.png\",2500,0,\"Sea\",\"Large\",\"4 PM - 9 AM\",1,1,1,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,1,1,1,0,0,0), " +
                "(null,\"Freshwater goby\",\"freshwatergoby.png\",400,0,\"River\",\"Small\",\"4 PM - 9 AM\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Frog\",\"frog.png\",120,0,\"Pond\",\"Small\",\"All day\",0,0,0,0,1,1,1,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,1), " +
                "(null,\"Gar\",\"gar.png\",6000,0,\"Pond\",\"Very Large\",\"4 PM - 9 AM\",0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1), " +
                "(null,\"Giant snakehead\",\"giantsnakehead.png\",5500,0,\"Pond\",\"Large\",\"9 AM - 4 PM\",0,0,0,0,0,1,1,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1), " +
                "(null,\"Giant trevally\",\"gianttrevally.png\",4500,0,\"Pier\",\"Very Large\",\"All day\",0,0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,0,1,1), " +
                "(null,\"Golden trout\",\"goldentrout.png\",15000,0,\"River (Clifftop)\",\"Medium\",\"4 PM - 9 AM\",0,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1,1,0), " +
                "(null,\"Goldfish\",\"goldfish.png\",1300,0,\"Pond\",\"Tiny\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Great white shark\",\"greatwhiteshark.png\",15000,0,\"Sea\",\"Huge (Fin)\",\"4 PM - 9 AM\",0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1), " +
                "(null,\"Guppy\",\"guppy.png\",1300,0,\"River\",\"Tiny\",\"9 AM - 4 PM\",0,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,1,1,1), " +
                "(null,\"Hammerhead shark\",\"hammerheadshark.png\",8000,0,\"Sea\",\"Huge (Fin)\",\"4 PM - 9 AM\",0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1), " +
                "(null,\"Horse mackerel\",\"horsemackerel.png\",150,0,\"Sea\",\"Small\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Killifish\",\"killifish.png\",300,0,\"Pond\",\"Tiny\",\"All day\",0,0,0,1,1,1,1,1,0,0,0,0,1,1,0,0,0,0,0,0,0,1,1,1), " +
                "(null,\"King salmon\",\"kingsalmon.png\",1800,0,\"River (Mouth)\",\"Huge\",\"All day\",0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0), " +
                "(null,\"Koi\",\"koi.png\",4000,0,\"Pond\",\"Large\",\"4 PM - 9 AM\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Loach\",\"loach.png\",400,0,\"River\",\"Small\",\"All day\",0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0), " +
                "(null,\"Mahi-mahi\",\"mahimahi.png\",6000,0,\"Pier\",\"Very Large\",\"All day\",0,0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,0,1,1), " +
                "(null,\"Mitten crab\",\"mittencrab.png\",2000,0,\"River\",\"Small\",\"4 PM - 9 AM\",0,0,0,0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0), " +
                "(null,\"Moray eel\",\"morayeel.png\",2000,0,\"Sea\",\"Narrow\",\"All day\",0,0,0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0), " +
                "(null,\"Napoleonfish\",\"napoleonfish.png\",10000,0,\"Sea\",\"Huge\",\"4 AM - 9 PM\",0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0), " +
                "(null,\"Neon tetra\",\"neontetra.png\",500,0,\"River\",\"Tiny\",\"9 AM - 4 PM\",0,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,1,1,1), " +
                "(null,\"Nibble fish\",\"nibblefish.png\",1500,0,\"River\",\"Tiny\",\"9 AM - 4 PM\",0,0,0,0,1,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1), " +
                "(null,\"Oarfish\",\"oarfish.png\",9000,0,\"Sea\",\"Huge\",\"All day\",1,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,1,0), " +
                "(null,\"Ocean sunfish\",\"oceansunfish.png\",4000,0,\"Sea\",\"Huge (Fin)\",\"4 AM - 9 PM\",0,0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0), " +
                "(null,\"Olive flounder\",\"oliveflounder.png\",800,0,\"Sea\",\"Very Large\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Pale chub\",\"palechub.png\",200,0,\"River\",\"Tiny\",\"9 AM - 4 PM\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Pike\",\"pike.png\",1800,0,\"River\",\"Very Large\",\"All day\",0,0,0,0,0,0,0,0,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,0), " +
                "(null,\"Piranha\",\"piranha.png\",2500,0,\"River\",\"Small\",\"9 AM - 4 PM & 9 PM - 4 AM\",0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1), " +
                "(null,\"Pond smelt\",\"pondsmelt.png\",500,0,\"River\",\"Small\",\"All day\",1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,0,0,0,0), " +
                "(null,\"Pop-eyed goldfish\",\"popeyedgoldfish.png\",1300,0,\"Pond\",\"Tiny\",\"9 AM - 4 PM\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Puffer fish\",\"pufferfish.png\",250,0,\"Sea\",\"Medium\",\"All day\",0,0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0), " +
                "(null,\"Rainbowfish\",\"rainbowfish.png\",800,0,\"River\",\"Tiny\",\"9 AM - 4 PM\",0,0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,0,1,1), " +
                "(null,\"Ranchu goldfish\",\"ranchugoldfish.png\",4500,0,\"Pond\",\"Small\",\"9 AM - 4 PM\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Ray\",\"ray.png\",3000,0,\"Sea\",\"Very Large\",\"4 AM - 9 PM\",0,0,0,0,0,0,0,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,0,0), " +
                "(null,\"Red snapper\",\"redsnapper.png\",3000,0,\"Sea\",\"Large\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Ribbon eel\",\"ribboneel.png\",600,0,\"Sea\",\"Narrow\",\"All day\",0,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,0,0,1), " +
                "(null,\"Saddled bichir\",\"saddledbichir.png\",4000,0,\"River\",\"Large\",\"9 PM - 4 AM\",0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1), " +
                "(null,\"Salmon\",\"salmon.png\",700,0,\"River (Mouth)\",\"Large\",\"All day\",0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0), " +
                "(null,\"Saw shark\",\"sawshark.png\",12000,0,\"Sea\",\"Huge (Fin)\",\"4 PM - 9 AM\",0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1), " +
                "(null,\"Sea bass\",\"seabass.png\",400,0,\"Sea\",\"Very Large\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), " +
                "(null,\"Sea butterfly\",\"seabutterfly.png\",1000,0,\"Sea\",\"Tiny\",\"All day\",1,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,0,0,0), " +
                "(null,\"Sea horse\",\"seahorse.png\",1100,0,\"Sea\",\"Tiny\",\"All day\",0,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,1,1,1), " +
                "(null,\"Snapping Turtle\",\"snappingturtle.png\",5000,0,\"River\",\"Large\",\"9 PM - 4 AM\",0,0,0,1,1,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,1,1,1), " +
                "(null,\"Soft-shelled turtle\",\"softshelledturtle.png\",3750,0,\"River\",\"Large\",\"4 PM - 9 AM\",0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0), " +
                "(null,\"Squid\",\"squid.png\",500,0,\"Sea\",\"Medium\",\"All day\",1,1,1,1,1,1,1,1,0,0,0,1,1,1,0,0,0,1,1,1,1,1,1,1), " +
                "(null,\"Stringfish\",\"stringfish.png\",15000,0,\"River (Clifftop)\",\"Very Large\",\"4 PM - 9 AM\",1,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,0,0,0), " +
                "(null,\"Sturgeon\",\"sturgeon.png\",10000,0,\"River (Mouth)\",\"Huge\",\"All day\",1,1,1,0,0,0,0,0,1,1,1,1,0,0,1,1,1,1,1,1,1,0,0,0), " +
                "(null,\"Suckerfish\",\"suckerfish.png\",1500,0,\"Sea\",\"Large (Fin)\",\"All day\",0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1), " +
                "(null,\"Surgeonfish\",\"surgeonfish.png\",1000,0,\"Sea\",\"Small\",\"All day\",0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1), " +
                "(null,\"Sweetfish\",\"sweetfish.png\",900,0,\"River\",\"Medium\",\"All day\",0,0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0), " +
                "(null,\"Tadpole\",\"tadpole.png\",100,0,\"Pond\",\"Tiny\",\"All day\",0,0,1,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1), " +
                "(null,\"Tilapia\",\"tilapia.png\",800,0,\"River\",\"Medium\",\"All day\",0,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,0,0,1), " +
                "(null,\"Tuna\",\"tuna.png\",7000,0,\"Pier\",\"Huge\",\"All day\",1,1,1,1,0,0,0,0,0,0,1,1,0,0,0,0,1,1,1,1,1,1,0,0), " +
                "(null,\"Whale shark\",\"whaleshark.png\",13000,0,\"Sea\",\"Huge (Fin)\",\"All day\",0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1), " +
                "(null,\"Yellow perch\",\"yellowperch.png\",300,0,\"River\",\"Medium\",\"All day\",1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,1,1,1,1,1,1,0,0,0), " +
                "(null,\"Zebra turkeyfish\",\"zebraturkeyfish.png\",500,0,\"Sea\",\"Medium\",\"All day\",0,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,1,1,1);"

        val createBugsTable:String = "CREATE TABLE Bugs (id integer PRIMARY KEY," +
                "name varchar," +
                "image varchar," +
                "price integer," +
                "donated integer," +
                "location varchar," +
                "time varchar," +
                "nJan integer," +
                "nFeb integer," +
                "nMar integer," +
                "nApr integer," +
                "nMay integer," +
                "nJun integer," +
                "nJul integer," +
                "nAug integer," +
                "nSep integer," +
                "nOct integer," +
                "nNov integer," +
                "nDec integer," +
                "sJan integer," +
                "sFeb integer," +
                "sMar integer," +
                "sApr integer," +
                "sMay integer," +
                "sJun integer," +
                "sJul integer," +
                "sAug integer," +
                "sSep integer," +
                "sOct integer," +
                "sNov integer," +
                "sDec integer," +
                "hemisphere integer DEFAULT 0);"

        val insertBugsStatement: String = "INSERT INTO Bugs (id,name,image,price,donated,location,time,nJan,nFeb,nMar,nApr,nMay, " +
                "nJun,nJul,nAug,nSep,nOct,nNov,nDec,sJan,sFeb,sMar,sApr,sMay,sJun,sJul,sAug,sSep,sOct,sNov,sDec) VALUES " +
                "(null,\"Agrias butterfly\",\"agriasbutterfly.png\",3000,0,\"Flying\",\"8 AM - 5 PM\",0,0,1,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1)," +
                "(null,\"Ant\",\"ant.png\",80,0,\"On rotten food\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Atlas moth\",\"atlasmoth.png\",3000,0,\"On Trees\",\"7 PM - 4 AM\",0,0,1,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1)," +
                "(null,\"Bagworm\",\"bagworm.png\",600,0,\"Shaking Trees\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Banded dragonfly\",\"bandeddragonfly.png\",4500,0,\"Flying\",\"8 AM - 5 PM\",0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,1,0,0,0,0,0,0,1,1)," +
                "(null,\"Bell cricket\",\"bellcricket.png\",430,0,\"On the Ground\",\"5 PM - 8 AM\",0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0)," +
                "(null,\"Blue weevil beetle\",\"blueweevilbeetle.png\",800,0,\"On Trees (Coconut?)\",\"All day\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Brown cicada\",\"browncicada.png\",250,0,\"On Trees\",\"8 AM - 5 PM\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Centipede\",\"centipede.png\",300,0,\"Hitting Rocks\",\"4 PM - 11 PM\",1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Cicada shell\",\"cicadashell.png\",10,0,\"On Trees\",\"All day\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Citrus long-horned beetle\",\"citruslonghornedbeetle.png\",350,0,\"On Tree Stumps\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Common bluebottle\",\"commonbluebottle.png\",300,0,\"Flying\",\"4 AM - 7 PM\",0,0,1,1,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,1,1)," +
                "(null,\"Common butterfly\",\"commonbutterfly.png\",160,0,\"Flying\",\"4 AM - 7 PM\",1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Cricket\",\"cricket.png\",130,0,\"On the Ground\",\"5 PM - 8 AM\",0,0,0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0)," +
                "(null,\"Cyclommatus stag\",\"cyclommatusstag.png\",8000,0,\"On Trees (Coconut)\",\"5 PM - 8 AM\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Damselfly\",\"damselfly.png\",500,0,\"Flying\",\"All day\",1,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0)," +
                "(null,\"Darner dragonfly\",\"darnerdragonfly.png\",230,0,\"Flying\",\"8 AM - 5 PM\",0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,0,0,0,0,0,1,1,1)," +
                "(null,\"Diving beetle\",\"divingbeetle.png\",800,0,\"On Ponds and Rivers\",\"8 AM - 7 PM\",0,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1)," +
                "(null,\"Drone beetle\",\"dronebeetle.png\",200,0,\"On Trees\",\"All day\",0,0,0,0,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1)," +
                "(null,\"Dung beetle\",\"dungbeetle.png\",3000,0,\"On the Ground (rolling snowballs)\",\"All day\",1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,1,1,0,0,0,0)," +
                "(null,\"Earth-boring dung beetle\",\"earthboringdungbeetle.png\",300,0,\"On the Ground\",\"All day\",0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Emperor butterfly\",\"emperorbutterfly.png\",4000,0,\"Flying\",\"5 PM - 8 AM\",1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1)," +
                "(null,\"Evening cicada\",\"eveningcicada.png\",550,0,\"On Trees\",\"4 AM - 8 AM & 4 PM - 7 PM\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Firefly\",\"firefly.png\",300,0,\"Flying\",\"7 PM - 4 AM\",0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1)," +
                "(null,\"Flea\",\"flea.png\",70,0,\"Villager's Heads\",\"All day\",0,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1)," +
                "(null,\"Fly\",\"fly.png\",60,0,\"On Trash Items\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Giant cicada\",\"giantcicada.png\",500,0,\"On Trees\",\"8 AM - 5 PM\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Giant stag\",\"giantstag.png\",10000,0,\"On Trees\",\"11 PM - 8 AM\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Giant water bug\",\"giantwaterbug.png\",2000,0,\"On Ponds and Rivers\",\"7 PM - 8 AM\",0,0,1,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1)," +
                "(null,\"Giraffe stag\",\"giraffestag.png\",12000,0,\"On Trees (Coconut?)\",\"5 PM - 8 AM\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Golden stag\",\"goldenstag.png\",12000,0,\"On Trees (Coconut)\",\"5 PM - 8 AM\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Goliath beetle\",\"goliathbeetle.png\",8000,0,\"On Trees (Coconut)\",\"5 PM - 8 AM\",0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1)," +
                "(null,\"Grasshopper\",\"grasshopper.png\",160,0,\"On the Ground\",\"8 AM - 5 PM\",0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Great purple emperor\",\"greatpurpleemperor.png\",3000,0,\"Flying\",\"4 AM - 7 PM\",0,0,0,1,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,1)," +
                "(null,\"Hermit crab\",\"hermitcrab.png\",1000,0,\"Beach disguised as Shells\",\"7 PM - 8 AM\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Honeybee\",\"honeybee.png\",200,0,\"Flying\",\"8 AM - 5 PM\",0,1,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1)," +
                "(null,\"Horned atlas\",\"hornedatlas.png\",8000,0,\"On Trees (Coconut)\",\"5 PM - 8 AM\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Horned dynastid\",\"horneddynastid.png\",1350,0,\"On Trees\",\"5 PM - 8 AM\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Horned elephant\",\"hornedelephant.png\",8000,0,\"On Trees (Coconut)\",\"5 PM - 8 AM\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Horned hercules\",\"hornedhercules.png\",12000,0,\"On Trees (Coconut)\",\"5 PM - 8 AM\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Jewel beetle\",\"jewelbeetle.png\",2400,0,\"On Tree Stumps\",\"All day\",0,0,1,1,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,1,1)," +
                "(null,\"Ladybug\",\"ladybug.png\",200,0,\"On Flowers\",\"8 AM - 5 PM\",0,1,1,1,1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,1,1,1)," +
                "(null,\"Long locust\",\"longlocust.png\",200,0,\"On the Ground\",\"8 AM - 7 PM\",0,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1)," +
                "(null,\"Madagascan sunset moth\",\"madagascansunsetmoth.png\",2500,0,\"Flying\",\"8 AM - 4 PM\",0,0,1,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1)," +
                "(null,\"Man-faced stink bug\",\"manfacedstinkbug.png\",1000,0,\"On Flowers\",\"7 PM - 8 AM\",0,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1)," +
                "(null,\"Mantis\",\"mantis.png\",430,0,\"On Flowers\",\"8 AM - 5 PM\",0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,1,1,1,1)," +
                "(null,\"Migratory locust\",\"migratorylocust.png\",600,0,\"On the Ground\",\"8 AM - 7 PM\",0,0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,1,0,0,0,0,0,0,0)," +
                "(null,\"Miyama stag\",\"miyamastag.png\",1000,0,\"On Trees\",\"All day\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Mole cricket\",\"molecricket.png\",500,0,\"Underground\",\"All day\",1,1,1,1,0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,1,1,0)," +
                "(null,\"Monarch butterfly\",\"monarchbutterfly.png\",140,0,\"Flying\",\"4 AM - 5 PM\",0,0,0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0)," +
                "(null,\"Mosquito\",\"mosquito.png\",130,0,\"Flying\",\"5 PM - 4 AM\",0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1)," +
                "(null,\"Moth\",\"moth.png\",130,0,\"Flying by Light\",\"7 PM - 4 AM\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Orchid mantis\",\"orchidmantis.png\",2400,0,\"On Flowers (White)\",\"8 AM - 5 PM\",0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,1,1,1,1)," +
                "(null,\"Paper kite butterfly\",\"paperkitebutterfly.png\",1000,0,\"Flying\",\"8 AM - 7 PM\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Peacock butterfly\",\"peacockbutterfly.png\",2500,0,\"Flying by Hybrid Flowers\",\"4 AM - 7 PM\",0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1)," +
                "(null,\"Pill bug\",\"pillbug.png\",250,0,\"Hitting Rocks\",\"11 PM - 4 PM\",1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Pondskater\",\"pondskater.png\",130,0,\"On Ponds and Rivers\",\"8 AM - 7 PM\",0,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1)," +
                "(null,\"Queen Alexandra's birdwing\",\"queenalexandrasbirdwing.png\",4000,0,\"Flying\",\"8 AM - 4 PM\",0,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1)," +
                "(null,\"Rainbow stag\",\"rainbowstag.png\",6000,0,\"On Trees\",\"7 PM - 8 AM\",0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1)," +
                "(null,\"Rajah Brooke's birdwing\",\"rajahbrookesbirdwing.png\",2500,0,\"Flying\",\"8 AM - 5 PM\",1,0,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,0,1,1,1)," +
                "(null,\"Red dragonfly\",\"reddragonfly.png\",180,0,\"Flying\",\"8 AM - 7 PM\",0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0)," +
                "(null,\"Rice grasshopper\",\"ricegrasshopper.png\",160,0,\"On the Ground\",\"8 AM - 7 PM\",0,0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,1,0,0,0,0,0,0,0)," +
                "(null,\"Robust cicada\",\"robustcicada.png\",300,0,\"On Trees\",\"8 AM - 5 PM\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Rosalia batesi beetle\",\"rosaliabatesibeetle.png\",3000,0,\"On Tree Stumps\",\"All day\",0,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1)," +
                "(null,\"Saw stag\",\"sawstag.png\",2000,0,\"On Trees\",\"All day\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Scarab beetle\",\"scarabbeetle.png\",10000,0,\"On Trees\",\"11 PM - 8 AM\",0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Scorpion\",\"scorpion.png\",8000,0,\"On the Ground\",\"7 PM - 4 AM\",0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,1,0,0,0,0,0,0,1,1), " +
                "(null,\"Snail\",\"snail.png\",250,0,\"On Rocks (Rain)\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Spider\",\"spider.png\",600,0,\"Shaking Trees\",\"7 PM - 8 AM\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Stinkbug\",\"stinkbug.png\",120,0,\"On Flowers\",\"All day\",0,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1)," +
                "(null,\"Tarantula\",\"tarantula.png\",8000,0,\"On the Ground\",\"7 PM - 4 AM\",1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,1,0,0)," +
                "(null,\"Tiger beetle\",\"tigerbeetle.png\",1500,0,\"On the Ground\",\"All day\",1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,0,0,0,1,1,1,1,1)," +
                "(null,\"Tiger butterfly\",\"tigerbutterfly.png\",240,0,\"Flying\",\"4 AM - 7 PM\",0,1,1,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,1,1,1)," +
                "(null,\"Violin beetle\",\"violinbeetle.png\",450,0,\"On Tree Stumps\",\"All day\",0,0,0,1,1,0,0,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,1)," +
                "(null,\"Walker cicada\",\"walkercicada.png\",400,0,\"On Trees\",\"8 AM - 5 PM\",0,0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Walking leaf\",\"walkingleaf.png\",600,0,\"Under Trees Disguised as Leafs\",\"All day\",0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0)," +
                "(null,\"Walking stick\",\"walkingstick.png\",600,0,\"On Trees\",\"4 AM - 8 AM & 5 PM - 7 PM\",0,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,0,0,0,0)," +
                "(null,\"Wasp\",\"wasp.png\",2500,0,\"Shaking Trees\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Wharf roach\",\"wharfroach.png\",200,0,\"On Beach Rocks\",\"All day\",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)," +
                "(null,\"Yellow butterfly\",\"yellowbutterfly.png\",160,0,\"Flying\",\"4 AM - 7 PM\",0,1,1,1,1,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,1,1,1,1);"

        db.execSQL(createFossilTable)
        db.execSQL(createFishTable)
        db.execSQL(createBugsTable)
        db.execSQL(insertFossilStatement)
        db.execSQL(insertFishStatement)
        db.execSQL(insertBugsStatement)
    }

    fun setHemisphere(hemisphere: Int){

        val hemisphereStatementBug:String
        val hemisphereStatementFish:String

        if(hemisphere == 1){
            hemisphereStatementBug = "UPDATE TABLE Bugs SET hemisphere = 1"
            hemisphereStatementFish = "UPDATE TABLE Fish SET hemisphere = 1"
        }else {
            hemisphereStatementBug = "UPDATE TABLE Bugs SET hemisphere = 0"
            hemisphereStatementFish = "UPDATE TABLE Fish SET hemisphere = 0"
        }

        val db: SQLiteDatabase = writableDatabase
        db.execSQL(hemisphereStatementBug)
        db.execSQL(hemisphereStatementFish)

    }

    fun updateFossil(fossil:Fossil, status: Int){
        val db = writableDatabase
        val cv = ContentValues()
        cv.put(FCOL_ID, fossil.id)
        cv.put(FCOL_NAME, fossil.name)
        cv.put(FCOL_IMAGE, fossil.image)
        cv.put(FCOL_DONATED, status)
        cv.put(FCOL_SELLPRICE, fossil.sellPrice)
        db.update(TABLE_FOSSILS,cv,"$FCOL_ID=?" , arrayOf(fossil.id.toString()))
    }

    fun getFossils(): MutableList<Fossil>{
        val result: MutableList<Fossil> = ArrayList()
        val db:SQLiteDatabase = readableDatabase
        val queryResult: Cursor = db.rawQuery("SELECT * FROM $TABLE_FOSSILS", null)
        if(queryResult.moveToFirst()){
            do{
                val fossil = Fossil()
                fossil.id = queryResult.getInt(queryResult.getColumnIndex(FCOL_ID))
                fossil.name = queryResult.getString(queryResult.getColumnIndex(FCOL_NAME))
                fossil.image = queryResult.getString(queryResult.getColumnIndex(FCOL_IMAGE))
                fossil.donated = queryResult.getInt(queryResult.getColumnIndex(FCOL_DONATED))
                fossil.sellPrice = queryResult.getInt(queryResult.getColumnIndex(FCOL_SELLPRICE))
                result.add(fossil)
            } while(queryResult.moveToNext())
        }
        queryResult.close()
        return result
    }

    fun updateFish(fish:Fish, status: Int){
        val db = writableDatabase
        val cv = ContentValues()
        cv.put("id", fish.id)
        cv.put("name", fish.name)
        cv.put("image", fish.image)
        cv.put("price", fish.price)
        cv.put("donated", status)
        cv.put("location", fish.location)
        cv.put("shadow", fish.shadow)
        cv.put("time", fish.time)
        cv.put("nJan", fish.NJan)
        cv.put("nFeb", fish.NFeb)
        cv.put("nMar", fish.NMar)
        cv.put("nApr", fish.NApr)
        cv.put("nMay", fish.NMay)
        cv.put("nJun", fish.NJun)
        cv.put("nJul", fish.NJul)
        cv.put("nAug", fish.NAug)
        cv.put("nSep", fish.NSep)
        cv.put("nOct", fish.NOct)
        cv.put("nNov", fish.NNov)
        cv.put("nDec", fish.NDec)
        cv.put("sJan", fish.SJan)
        cv.put("sFeb", fish.SFeb)
        cv.put("sMar", fish.SMar)
        cv.put("sApr", fish.SApr)
        cv.put("sMay", fish.SMay)
        cv.put("sJun", fish.SJun)
        cv.put("sJul", fish.SJul)
        cv.put("sAug", fish.SAug)
        cv.put("sSep", fish.SSep)
        cv.put("sOct", fish.SOct)
        cv.put("sNov", fish.SNov)
        cv.put("sDec", fish.SDec)
        db.update("Fish",cv,"$FCOL_ID=?" , arrayOf(fish.id.toString()))
    }

    fun getFish(): MutableList<Fish>{
        val result: MutableList<Fish> = ArrayList()
        val db:SQLiteDatabase = readableDatabase
        val queryResult: Cursor = db.rawQuery("SELECT * FROM Fish", null)
        if(queryResult.moveToFirst()){
            do{
                val fish = Fish()
                fish.id = queryResult.getInt(queryResult.getColumnIndex("id"))
                fish.name = queryResult.getString(queryResult.getColumnIndex("name"))
                fish.image = queryResult.getString(queryResult.getColumnIndex("image"))
                fish.price = queryResult.getInt(queryResult.getColumnIndex("price"))
                fish.donated = queryResult.getInt(queryResult.getColumnIndex("donated"))
                fish.location = queryResult.getString(queryResult.getColumnIndex("location"))
                fish.shadow = queryResult.getString(queryResult.getColumnIndex("shadow"))
                fish.time = queryResult.getString(queryResult.getColumnIndex("time"))
                fish.NJan = queryResult.getInt(queryResult.getColumnIndex("nJan"))
                fish.NFeb = queryResult.getInt(queryResult.getColumnIndex("nFeb"))
                fish.NMar = queryResult.getInt(queryResult.getColumnIndex("nMar"))
                fish.NApr = queryResult.getInt(queryResult.getColumnIndex("nApr"))
                fish.NMay = queryResult.getInt(queryResult.getColumnIndex("nMay"))
                fish.NJun = queryResult.getInt(queryResult.getColumnIndex("nJun"))
                fish.NJul = queryResult.getInt(queryResult.getColumnIndex("nJul"))
                fish.NAug = queryResult.getInt(queryResult.getColumnIndex("nAug"))
                fish.NSep = queryResult.getInt(queryResult.getColumnIndex("nSep"))
                fish.NOct = queryResult.getInt(queryResult.getColumnIndex("nOct"))
                fish.NNov = queryResult.getInt(queryResult.getColumnIndex("nNov"))
                fish.NDec = queryResult.getInt(queryResult.getColumnIndex("nDec"))
                fish.SJan = queryResult.getInt(queryResult.getColumnIndex("sJan"))
                fish.SFeb = queryResult.getInt(queryResult.getColumnIndex("sFeb"))
                fish.SMar = queryResult.getInt(queryResult.getColumnIndex("sMar"))
                fish.SApr = queryResult.getInt(queryResult.getColumnIndex("sApr"))
                fish.SMay = queryResult.getInt(queryResult.getColumnIndex("sMay"))
                fish.SJun = queryResult.getInt(queryResult.getColumnIndex("sJun"))
                fish.SJul = queryResult.getInt(queryResult.getColumnIndex("sJul"))
                fish.SAug = queryResult.getInt(queryResult.getColumnIndex("sAug"))
                fish.SSep = queryResult.getInt(queryResult.getColumnIndex("sSep"))
                fish.SOct = queryResult.getInt(queryResult.getColumnIndex("sOct"))
                fish.SNov = queryResult.getInt(queryResult.getColumnIndex("sNov"))
                fish.SDec = queryResult.getInt(queryResult.getColumnIndex("sDec"))
                result.add(fish)
            } while(queryResult.moveToNext())
        }
        queryResult.close()
        return result
    }

    fun updateBug(bug:Bug, status: Int){
        val db = writableDatabase
        val cv = ContentValues()
        cv.put("id", bug.id)
        cv.put("name", bug.name)
        cv.put("image", bug.image)
        cv.put("price", bug.price)
        cv.put("donated", status)
        cv.put("location", bug.location)
        cv.put("time", bug.time)
        cv.put("nJan", bug.NJan)
        cv.put("nFeb", bug.NFeb)
        cv.put("nMar", bug.NMar)
        cv.put("nApr", bug.NApr)
        cv.put("nMay", bug.NMay)
        cv.put("nJun", bug.NJun)
        cv.put("nJul", bug.NJul)
        cv.put("nAug", bug.NAug)
        cv.put("nSep", bug.NSep)
        cv.put("nOct", bug.NOct)
        cv.put("nNov", bug.NNov)
        cv.put("nDec", bug.NDec)
        cv.put("sJan", bug.SJan)
        cv.put("sFeb", bug.SFeb)
        cv.put("sMar", bug.SMar)
        cv.put("sApr", bug.SApr)
        cv.put("sMay", bug.SMay)
        cv.put("sJun", bug.SJun)
        cv.put("sJul", bug.SJul)
        cv.put("sAug", bug.SAug)
        cv.put("sSep", bug.SSep)
        cv.put("sOct", bug.SOct)
        cv.put("sNov", bug.SNov)
        cv.put("sDec", bug.SDec)
        db.update("Bugs",cv,"$FCOL_ID=?" , arrayOf(bug.id.toString()))
    }

    fun getBug(): MutableList<Bug>{
        val result: MutableList<Bug> = ArrayList()
        val db:SQLiteDatabase = readableDatabase
        val queryResult: Cursor = db.rawQuery("SELECT * FROM Bugs", null)
        if(queryResult.moveToFirst()){
            do{
                val bug = Bug()
                bug.id = queryResult.getInt(queryResult.getColumnIndex("id"))
                bug.name = queryResult.getString(queryResult.getColumnIndex("name"))
                bug.image = queryResult.getString(queryResult.getColumnIndex("image"))
                bug.price = queryResult.getInt(queryResult.getColumnIndex("price"))
                bug.donated = queryResult.getInt(queryResult.getColumnIndex("donated"))
                bug.location = queryResult.getString(queryResult.getColumnIndex("location"))
                bug.time = queryResult.getString(queryResult.getColumnIndex("time"))
                bug.NJan = queryResult.getInt(queryResult.getColumnIndex("nJan"))
                bug.NFeb = queryResult.getInt(queryResult.getColumnIndex("nFeb"))
                bug.NMar = queryResult.getInt(queryResult.getColumnIndex("nMar"))
                bug.NApr = queryResult.getInt(queryResult.getColumnIndex("nApr"))
                bug.NMay = queryResult.getInt(queryResult.getColumnIndex("nMay"))
                bug.NJun = queryResult.getInt(queryResult.getColumnIndex("nJun"))
                bug.NJul = queryResult.getInt(queryResult.getColumnIndex("nJul"))
                bug.NAug = queryResult.getInt(queryResult.getColumnIndex("nAug"))
                bug.NSep = queryResult.getInt(queryResult.getColumnIndex("nSep"))
                bug.NOct = queryResult.getInt(queryResult.getColumnIndex("nOct"))
                bug.NNov = queryResult.getInt(queryResult.getColumnIndex("nNov"))
                bug.NDec = queryResult.getInt(queryResult.getColumnIndex("nDec"))
                bug.SJan = queryResult.getInt(queryResult.getColumnIndex("sJan"))
                bug.SFeb = queryResult.getInt(queryResult.getColumnIndex("sFeb"))
                bug.SMar = queryResult.getInt(queryResult.getColumnIndex("sMar"))
                bug.SApr = queryResult.getInt(queryResult.getColumnIndex("sApr"))
                bug.SMay = queryResult.getInt(queryResult.getColumnIndex("sMay"))
                bug.SJun = queryResult.getInt(queryResult.getColumnIndex("sJun"))
                bug.SJul = queryResult.getInt(queryResult.getColumnIndex("sJul"))
                bug.SAug = queryResult.getInt(queryResult.getColumnIndex("sAug"))
                bug.SSep = queryResult.getInt(queryResult.getColumnIndex("sSep"))
                bug.SOct = queryResult.getInt(queryResult.getColumnIndex("sOct"))
                bug.SNov = queryResult.getInt(queryResult.getColumnIndex("sNov"))
                bug.SDec = queryResult.getInt(queryResult.getColumnIndex("sDec"))
                result.add(bug)
            } while(queryResult.moveToNext())
        }
        queryResult.close()
        return result
    }

}