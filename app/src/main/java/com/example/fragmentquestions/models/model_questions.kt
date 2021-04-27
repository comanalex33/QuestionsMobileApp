package com.example.fragmentquestions.models

class Question(var text: String, var answer: String, var options: List<String>, var choosed: Boolean = false)

object Supplier{

    val questions = listOf(

        //Limba romana - 0
        listOf(
            Question("Antonimul cuvantului \"autentic\" este?","fals", listOf("exceptat","motivat","justificat","fals")),
            Question("Cine a scris poezia \"Iarna\"?","Vasile Alecsandri", listOf("Mihai Eminescu","George Cosbuc","Vasile Alecsandri","Ion Creanga")),
            Question("Ce este epitetul?","Figura de stil", listOf("Parte de propozitie","Figura de stil","Un semtiment","Niciun raspuns nu este bun")),
            Question("Cate strofe are poezia Luceafarul?","98", listOf("49","81","98","100")),
            Question("Care dintre urmatoarele opere este scrisa de Ion Creanga?","Amintiri din Copilarie",
                listOf("Luceafarul","Ion","Amintiri lui Guliver","Amintiri din Copilarie")),
            Question("În fraza: \"El mi-a vorbit îndelung despre această carte ca s-o caut, la rândul meu şi să-i descopăr în miile-i de pagini, misterul.\" cuvântul \"i\" este:","adjectiv pronominal posesiv",
                listOf("adjectiv pronominal personal","pronume posesiv","adjectiv pronominal posesiv","pronume personal")),
            Question("Identificaţi contextul care nu reprezintă o formă de superlativ absolut:","mai frig decat in alte zile",
                listOf("mai frig decat in alte zile","ingrozitor de frig","frig de crapa pietrele","frrrig")),
            Question("Precizaţi câte greşeli, de orice natură, există în următoarea frază: \"Propri prieteni, precum şi fii, ce-i în care avea încredere, îl înşelaseră.\"","trei",
                listOf("doua","trei","una","patru")),
            Question("Alegeţi varianta care conţine cuvinte scrise corect:","rău-platnic, răuvoitor, bunăvoinţa, bună-credinţă",
                listOf("rău-platnic, răuvoitor, bunăvoinţa, bună-credinţă","rău platnic, rău voitor, bunăvoinţa, bună credinţă","rău platnic, răuvoitor, bună voinţă, bună-credinţă","rău-platnic, răuvoitor, bună voinţă, bună credinţă")),
            Question("Cine a scris opera \"O scrisoare pierduta\"","I.L.Caragiale", listOf("Ion Creanga","Mihai Eminescu","Mircea Eliade","I.L.Caragiale"))
        )

        //Geografie - 1
        , listOf(
            Question("Care este capitala Romaniei?","Bucuresti", listOf("Bucuresti", "Moscova", "Timisoara", "Cluj")),
            Question("Care este cel mai inalt varf din Romania?", "Vf. Fagaras", listOf("Vf. Omu", "Vf. Retezat", "Vf. Fagaras", "Vf. Mare")),
            Question("Ce tara din America de Sud are cea mai mare suprafata?", "Brazilia", listOf("Argentina","Brazilia","SUA","Peru")),
            Question("Din ce tara izvoraste Dunarea?", "Germania", listOf("Romania", "Austria","Germania","Franta")),
            Question("Cate state are SUA?","50",listOf("48","50","35","29")),
            Question("Care este cel mai inalt munte de pe glob?","Everest",listOf("Kilimanjaro","Alpi","Anzi","Everest")),
            Question("In ce oras poti vizita Colosseumul?","Roma",listOf("Roma","Atena","Berlin","Londra")),
            Question("Care este \"Animalul desertului\"?","Camila", listOf("Camila","Elefantul","Maimuta","Ghepardul")),
            Question("Care dintre urmatoarele orase au deschidere la Oceanul Atlantic?","Lisabona",
                listOf("Barcelona","Lisabona","Amsterdam","Londra")),
            Question("Cu cate tari se invecineaza Romania?","5", listOf("2","3","4","5"))
        )

        //Istorie - 2
        , listOf(
            Question("Ce nationalitate are \nPapa Francisc I?","Argentineana",listOf("Italiana","Franceza","Argentineana","Australiana")),
            Question("In ce perioada a avut loc Primul Razboi Mondial?","1914-1918", listOf("1914-1919","1920-1938","1914-1918","1913-1919")),
            Question("In ce an a intrat Romania in Uniunea Europeana?","2007", listOf("2007","2002","1997","2014")),
            Question("Cine a inventat becul?","Thomas Edison", listOf("Einstein","Aristotel","Thomas Edison","Stephen Hawking")),
            Question("Cati ani a durat Razboiul de 100 de ani?","116", listOf("100","113","95","116")),
            Question("Cine este presedintele Germaniei?","Angela Merkle", listOf("Klaus Iohannes","Kristofer Brown","Angela Merkle","Dom Shwartz"))
        )

        //Biologie - 3
        , listOf(
            Question("In ce organ se afla corzile vocale ale omului?","laringe", listOf("faringe","laringe","esofag","stomac")),
            Question("In ce se transforma omizile cand se dezvolta?","Fluture", listOf("Cal","Nu se poate transfoma","Fluture","Sarpe")),
            Question("Care este numele celui mai lung os din corpul uman?","Femur", listOf("Peroneu","Craniu","Femur","Ulna")),
            Question("Cate cavitati are inima?","4", listOf("3","4","5","2")),
            Question("Care sunt zonele delimitate de muschiul \"diafragma\"","Toracica si abdominala",
                listOf("Toracica si abdominala","Toracica si pelviana","Abdominala si Pelviana","Toracica si Lombara")),
            Question("Care este numarul de cromozomi al unei celule din corpul uman?","46", listOf("23","22","46","48"))
        )
    )
}