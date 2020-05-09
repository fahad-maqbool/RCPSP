package RCPSP
import scala.io.StdIn.readLine
import scala.collection.immutable
import scala.io.Source
import scala.reflect.internal.util.Collections




//#     Make your code modular and compact to make easily understandable. Currently all code in a single flow and single function.





object FinalCpm {
  //#   Starnge That you have declared so much variable.
  var Activities:List[String]  =  List()
  var Duration:List[String]  =  List()
  var Successor:List[String]  =  List()
  var Successor1:List[String]  =  List()    //#   Successor was enough then why this series of successor1,2,3...
  var Successor2:List[String]  =  List()
  var Successor3:List[String]  =  List()
  var Predecessor1:List[String]  =  List()    //#   Predecessor was enough then why this series of Predecessor1,2,3...
  var Predecessor2:List[String]  =  List()
  var Predecessor3:List[String]  =  List()
  var Predecessor:List[String]  =  List()
  var MActivities:List[String]  =  List()
  var MDuration:List[String]  =  List()
  var Modes:List[String]  =  List()
  var r1:List[String]  =  List()
  var r2:List[String]  =  List()
  var n1:List[String]  =  List()
  var n2:List[String]  =  List()
  var eet = 0 //Early End Time
  var eet1 = 0
  var eet2 = 0
  var eet3 = 0
  var est=0   //Early Start Time
  var p = 0.0
  var h = 0.0
  var p1 = 0.0
  var p2 = 0.0
  var p3 = 0.0
  var h1 = 0.0
  var h2 = 0.0
  var h3 = 0.0
  var prod = 1.0
  var prod1 = 1.0
  var prod2= 1.0
  var prod3 = 1.0
  var sum = 0.0
  var prob = 0.0
  var probability: Array[Double] = Array()
  var pheromone:Array[Double] = Array.fill(18)(0.1)
  //var pheromone:Array[Double] = Array(0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1)
  var alpha=1
  var beta=2
  var pEva=0.5
  var Mp = 0.0
  var Mh = 0.0
  var Mp1 = 0.0
  var Mp2 = 0.0
  var Mp3 = 0.0
  var Mh1 = 0.0
  var Mh2 = 0.0
  var Mh3 = 0.0
  var Mprod = 1.0
  var Mprod1 = 1.0
  var Mprod2= 1.0
  var Mprod3 = 1.0
  var Msum = 0.0
  var Mprob1 = 0.0
  var Mprob2 = 0.0
  var Mprob3 = 0.0
  var maxP = 0.0
  var Q = 100
  var L = 16
  var e = 16
  var Mprobability: Array[Double] = Array()
  //var Mpheromone:Array[Double] = Array(0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1)       
  var Mpheromone:Array[Double] = Array.fill(50)(0.1)
  //var length = 19
  // var lstFinal = Array[Int](length)
  // var eet4:Array[Int] = Array(5)
  var eetFinal:Array[Int] = Array()
  var eetList:Array[Int] = Array()
  var estFinal:Array[Int] = Array()
  var estList:Array[Int] = Array()
  //var Aheuristic:Array[Int] = Array()
  var Aheuristic:Array[Int] = Array()
  var Mheuristic:Array[Int] = Array()
  
  var pp2:Array[Int] = Array()
  var SModes:Array[Int] = Array()
  var Sduration:Array[Int] = Array()
  var Sr1:Array[Int] = Array()
  var Sr2:Array[Int] = Array()
  var Sn1:Array[Int] = Array()
  var Sn2:Array[Int] = Array()
  //var Aseq:Array[Int] = Array()
  //var Amode:Array[Int] = Array()
//  var STList:Array[Int] = Array()
  var STList:Array[Int] = Array.fill(16)(0)
  var EList:Array[Int] = Array()
  var st=0
  var EndT=0
  var sameProb=0.0
  var AglobalPheromone:Array[Double] = Array()
  var AlocalPheromone:Array[Double] = Array()
  var APhUpdation:Array[Double] = Array()
  var MglobalPheromone:Array[Double] = Array()
  var MlocalPheromone:Array[Double] = Array()
  var MPhUpdation:Array[Double] = Array()
  
 
  
  def main(args: Array[String]){
  
    val filename = "/home/fariha/dataaa"
    for (line <- Source.fromFile(filename).getLines) {    //#   This loop can be used during codding to test your import but not in final version as it may waste time.
    println(line)
    }
  
  var lines = Source.fromFile("/home/fariha/dataaa").getLines.toArray     //#   why you haven't used filename variable over here that declared earlier
    
  //#   There was no need for the following loop. This task can be done using map operation. Avoid loops as much as possible.
  for(i  <-  0 to lines.length -1  ){
      var s  =  lines(i).split(",")
      Activities  =  s(0)::Activities
      Duration  =  s(1)::Duration
      Successor1  =  s(2)::Successor1
      Successor2  =  s(3)::Successor2
      Successor3  =  s(4)::Successor3
      Successor  =  Successor1 ::: Successor2 ::: Successor3
      Predecessor1 = (s(5) :: Predecessor1)
      Predecessor2 = s(6) :: Predecessor2
      Predecessor3 = s(7) :: Predecessor3
      Predecessor = Predecessor1 ::: Predecessor2 ::: Predecessor3
   }
    
    //#   Avoid all following time consuming printouts. So comment these
      println("...........Activities Only......................")
      Activities.foreach(println)
      println("...........duration Only......................")
      Duration.foreach(println)
       println("...........Successors 1 Are......................")
      Successor1.foreach(println)
        println("...........Successors 2 Are......................")
      Successor2.foreach(println)
        println("...........Successors 3 Are......................")
      Successor3.foreach(println)
        println("...........Successors Are......................")
      Successor.foreach(println)
      println("........... Predecessor 1 Are......................")
       Predecessor1.foreach(println)
      println("........... Predecessor 2 Are......................")
       Predecessor2.foreach(println)
      println("........... Predecessor 3 Are......................")
       Predecessor3.foreach(println)
       println("........... Predecessor  Are......................")
       Predecessor.foreach(println)
       
       //eetList = eetList ++ Array(eet1)
       //eetList :+ eet1 //:+ eet2 :+ eet3
       eetFinal =  eetList ++ Array(eet1) ++ Array(eet2) ++ Array(eet3) //#    Unable to understand the purpose of these. Avoid global variables and try to use local variables as much as possible.
       estFinal =  estList ++ Array(est) 
       // println("eettttt " +eetList)
       println("eeeeeeetlist")
       for (a <- eetFinal ){    //#    Avoid printouts. And anyways this was possible to print using compact foreach
       println(a)
       }
        //println(eetList.mkString(","))
       //eetList foreach{ a => a foreach (println)}
       //eetList.foreach(println)
 
//////////////////////////////For Early Start and End Time///////////////////////////      
  for(i<- Activities.length-2 to 0 by -1){
         
           var current = Activities(i)
           println("...Current Activity..." + current)
           // for (j<- 0 to eetFinal.length-1){
           //println("j is "+ j)
        
           var PreIds1 =  Predecessor1(i).toInt
           println("1st Prdecessors " + PreIds1)
           var a = eetFinal(PreIds1 + 1)
           println("eet final " + a )
         
           var PreIds2 =  Predecessor2(i).toInt
           println("2nd Prdecessors ." + PreIds2)
           var b = eetFinal(PreIds2 + 1)
           println("eet final " + b)
        
           var PreIds3 =  Predecessor3(i).toInt
           println("3rd Predecessor ." + PreIds3)
           var c = eetFinal(PreIds3 + 1)
           println("eet final " + c)
        
        if( a>=b && a>=c){
           println("1st Greater predessessor " +a)
           est = a
         }
        else if(b>=c && b>=a){ 
          println("2nd Greater predesessor " +b)
          est = b
        }
        else if (c>=b && c>=a)  {
          println("3rd Greater predesessor " +c)
          est = c
        }
         
        eet = est + Duration(i).toInt
        println("Final Early End Time is" + eet)
        eetFinal =  eetFinal ++ Array(eet) 
        println("EETFinal is")
        
        for (a1 <- eetFinal ){
        println(a1)
        }
        
        estFinal =  estFinal ++ Array(est) 
        println("ESTFinal is")
        
        for (a1 <- estFinal ){
        println(a1)
        } 
  }
        
 //////////////////////////////For Late Start and End Time///////////////////////////       
       var let = eet
       var lst=0
       var a = 500
       var b = 500
       var c =500
       var pc : String = ""
       var nk : String = ""
       var letFinal:Array[Int] = Array()
       var letList:Array[Int] = Array()
       //var lstFinal:Array[Int] = Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,let)
       var lstFinal:Array[Int] = Array.fill(18)(let)
       var lstUpdate:Array[Int] = Array()
       var lstList:Array[Int] = Array()
       
      /* println("Checking of LSTUPDATED List")
       for (a12 <- lstUpdate ){
        println(a12)
       }
       println("Checking of LSTFINAL List")
        for (a12 <- lstFinal ){
        println(a12)
       }*/
      // lstFinal = lstFinal//++ Array(lst2) ++ Array(lst1) ++ Array(lst3)
       println("checkk LST Final List ")
       for (a11 <- lstFinal ){
       println(a11)
       }
       
       letFinal =  letList ++ Array(let)
       println("checkk LET Final list")
       for (a12 <- letFinal ){
        println(a12)
       }
   
    for(j<-1  to Activities.length-1){
         
          var current = Activities(j)
          println("...Current Activity..." + current)
          println("previous LETTTT " + let)
         
          var SucIds1 =  Successor1(j).toInt
          println("1st successor " + SucIds1)
          a = lstFinal(SucIds1-1)
          //var a = lstFinal(j-1)
          //var a = lstFinal(j-1)
          println("lst final " + a )
         
          var SucIds2 =  Successor2(j).toInt
          println("2nd Successor" + SucIds2)
        
        if (SucIds2 == 0){
        //pc = lstFinal(SucIds2)
        pc= "+"
        println("lst finalpc "+ pc )
        }
        else { 
          b = lstFinal(SucIds2 - 1) 
          println("lst final " + b)
          } 
        
        var SucIds3 =  Successor3(j).toInt
        println("3rd Successor" + SucIds3)
        if (SucIds3 == 0){
        nk= "+"
        println("lst finalnk "+ nk )
         }
        else { 
        c = lstFinal(SucIds3) 
        println("lst final " + c)
        } 
          
         
        if (a<b && a<c){
          println("1st Smaller Successor " +a)
          let = a
        } 
         
         if( b<c && b<a){ 
          println("2nd Smaller Successor " +b)
          let = b
        }
         if( c<b && c<a){
           println("3rd Smaller Successor " +c)
           let = c
         }
         //}
        
      lst = let - Duration(j).toInt
      println("Final Late Start Time" + lst)
      lstFinal = lstFinal.updated(Activities.length-j-1, lst)
          //lstFinal = lstFinal.updated(j, lst)
          //lstFinal = lstFinal.updated(j+2, lst)
          //lstFinal =  lstFinal ++ Array(lst) 
      println("LST FInal List is")
      for (a1 <- lstFinal ){
      println(a1)
      }
         
      letFinal =  letFinal ++ Array(let) 
      println("LET Final List is")
      for (a1 <- letFinal ){
      println(a1)
      }  
     
}
     /////////////////////////For HEURISTIC of Activities//////////////////////////////   
        println("it is ESTFinal")
        for (a1 <- estFinal ){
        println(a1)
        } 
        
        println("it is LST FInal List ")
        for (a1 <- lstFinal ){
        println(a1)
        }
      //var Fxy2 =0
     // var Fxy3 =0
    //  var FinalLsEs =0
  
 for(i<- Activities.length-1 to 0 by -1){
         var z1 = 0
         var z2 = 0
         var Fxyz = 0
         var Fxy1 = 0
         var Fxy2 =0
         var Fxy3 =0
         var FinalLsEs =0
         
         var current = Activities(i)
         println("...Current Activity..." + current)
         
         var SucIds1 =  Successor1(i).toInt
         println("1st successor " + SucIds1)
         
         if (SucIds1 == 0){
         //pc = lstFinal(SucIds2)
         pc= "+"
         println("lst and est finalpc "+ pc )
         }
        else {
         var x1 = estFinal(SucIds1-1)
         var y1 = lstFinal(SucIds1-1)
         println("1st successor est " + x1)
         println("1st successor lst " + y1)
         Fxy1 = y1 - x1
         println("Finalxy1 " + Fxy1)
        }
         var SucIds2 =  Successor2(i).toInt
         println("2nd successor " + SucIds2)
         if (SucIds2 == 0){
         //pc = lstFinal(SucIds2)
         pc= "+"
         println("lst and est finalpc "+ pc )
         }
        else { 
         var x2 = estFinal(SucIds2-1)
         var y2 = lstFinal(SucIds2-1)
         println("2nd successor est " + x2)
         println("2nd successor lst " + y2)
         Fxy2 = y2 - x2
         println("Finalxy2 " + Fxy2)
         }
         
         
         var SucIds3 =  Successor3(i).toInt
         println("3rd successor " + SucIds3)
         if (SucIds3 == 0){
         //pc = lstFinal(SucIds2)
          nk= "+"
          println("lst and est finalpc "+ nk )
         }
         else { 
          var x3 = estFinal(SucIds3-1)
          var y3 = lstFinal(SucIds3-1)
          println("3rd successor est " + x3)
          println("3rd successor lst " + y3)
          Fxy3 = y3 - x3
          println("Finalxy3 " + Fxy3)
        }
         
        if( Fxy1 >= Fxy2 && Fxy1 >= Fxy3){
           println("1st Greater Fxy1 " +Fxy1)
           FinalLsEs=Fxy1
         }
        
        else if(Fxy2>=Fxy1 && Fxy2>=Fxy3){ 
          println("2nd Greater Fxy2 " + Fxy2)
          FinalLsEs=Fxy2
        }
        else if (Fxy3>=Fxy1 && Fxy3>=Fxy2)  {
          println("3rd Greater Fxy3 " +Fxy3)
          FinalLsEs=Fxy3
        }
         println()
         
         z1 = lstFinal(Activities.length-i-1)
         z2 = estFinal(Activities.length-i-1)
         println(" lst of Activity is "+  z1)
         println(" est of Activity is "+ z2)
         Fxyz = z1 - z2
         println("Fxyz of Activity is "  + Fxyz)
         println()
         
         println("heuristic of Activities are ")
         var abc = FinalLsEs - Fxyz + 1
         Aheuristic = Aheuristic ++ Array(abc)
         for (h <- Aheuristic){
           println(h)
         }
  }
  //////////////////////////////For Probability of Activities///////////////////////////        
     for (i<- Activities.length-2 to 1 by -1 ){
           
           var current = Activities(i)
           println("...Current Activity..." + current)
         
           var SucIds1 =  Successor1(i).toInt
           println("1st successor " + SucIds1)
           if (SucIds1 == 0){
         //pc = lstFinal(SucIds2)
         pc= "+"
         println("heuristic is dummy "+ pc )
         }
        else {
           p1 = Math.pow(pheromone(SucIds1-1), alpha)
           println("Pheromone value")
           print(" "+ p1)
           println()
          
             h1 = Math.pow(Aheuristic(SucIds1-1), beta)
             println("Heuristic value")
             print(" "+ h1)
             println()
             
           prod1 = p1 * h1
           println("1st Successor's product of pheromone and heuristic is")
           print(" " + prod1)
           println()
        } 
        
         var SucIds2 =  Successor2(i).toInt
         println("2nd successor " + SucIds2)
        if (SucIds2 == 0){
         //pc = lstFinal(SucIds2)
         pc= "+"
         println("heuristic is dummy "+ pc )
         }
        else {
            p2 = Math.pow(pheromone(SucIds2-1), alpha)
           println("Pheromone value")
           print(" "+ p2)
           println()
          
              h2 = Math.pow(Aheuristic(SucIds2-1), beta)
             println("Heuristic value")
             print(" "+ h2)
             println()
             
           prod2= p2 * h2
           println("2nd Successor's product of pheromone and heuristic is")
           print(" " + prod2)
           println()
        } 
        
        
         var SucIds3 =  Successor3(i).toInt
         println("3rd successor " + SucIds3)
        if (SucIds3 == 0){
         //pc = lstFinal(SucIds2)
         pc= "+"
         println("heuristic is dummy "+ pc )
         }
        else {
            p3 = Math.pow(pheromone(SucIds3-1), alpha)
           println("Pheromone value")
           print(" "+ p3)
           println()
          
             h3 = Math.pow(Aheuristic(SucIds3-1), beta)
             println("Heuristic value")
             print(" "+ h3)
             println()
             
           prod3 = p3 * h3
           println("3rd Successor's product of pheromone and heuristic is")
           print(" " + prod3)
           println()
        } 
       sum = prod1+ prod2 + prod3
       println("Summ of all successor's product")
       print(" "+ sum)
       println()
         /////////////////// product of running main activity///////////////
        p = Math.pow(pheromone(i), alpha)
           println("Pheromone value")
           print(" "+ p)
           println()
           
        h = Math.pow(Aheuristic(Activities.length-i-1), beta)
            println("Heuristic value")
             print(" "+ h)
             println()
           println()  
           
        prod = p * h
           println("Activity's product of pheromone and heuristic is")
           print(" " + prod)
           println()
           
        prob = prod / sum
        probability = probability ++ Array(prob)
        //var pp1 = probability.zipWithIndex
        var pp1 = probability zip (Stream from 2)
        println("Probability is")
           for (p <- pp1){
             println(p)
           }
       println("Sorted Probability is")
       scala.util.Sorting.quickSort(pp1)
       
       for (p <- pp1){
            println(p)
       }
       println("Sorted index of Probability is")
       pp2 = pp1.map(x => (x._2))
       for (p <- pp2){
            println(p)
       }
       // var pp = pp1.zipWithIndex.foreach{ case(x,j) => println(j) }
       
       
   //    scala.util.Sorting.quickSort(pp)
     //  for (p <- pp){
       //      println(p)
         //  }
      }
     ////////////////////////////// Probability of modes///////////////////////
 val filename1 = "/home/fariha/FinalDataset"
    for (line <- Source.fromFile(filename1).getLines) {
    println(line)
    }
  var lines1 = Source.fromFile("/home/fariha/FinalDataset").getLines.toList
    for(i  <-  0 to lines1.length -1  ){
      var s1  =  lines1(i).split(",")
      MActivities  =  s1(0)::MActivities
      Modes  =  s1(1)::Modes
      MDuration  =  s1(2)::MDuration
      r1  =  s1(3)::r1
      r2  =  s1(4)::r2
      n1  =  s1(5)::n1
      n2  =  s1(6)::n2
      
    }
      println("...........Modes Activities Only......................")
      MActivities.foreach(println)
      
      println("...........Modes duration Only......................")
      MDuration.foreach(println)
      
      println("...........Modes Only......................")
      Modes.foreach(println)
      
      println("...........r1 Only......................")
      r1.foreach(println)
      
      println("...........r2 Only......................")
      r2.foreach(println)
      
      println("...........n1 Only......................")
      n1.foreach(println)
      
      println("...........n2 Only......................")
      n2.foreach(println)
      
      println("Total Modes are "+Modes.length)
      println("Total Duration is "+MDuration.length)
      
      var maxD=0
      var Sm = 0
      var Sd = 0
      var Sre1 = 0
      var Sre11 = 0
      var Sne1 = 0
      var Sne11 = 0
     
      for (i<- MActivities.length-2 to 1 by -3 ){
          
          var current = MActivities(i)
          println("Current Activity" + current)
          //var a = Modes(Modes.length-i-2)  
          // var a = Modes(Modes.length-2*i)
          
          var a = Modes(i)
          //var c = Modes(Modes.length-i-1)
          println("Modes " + a)
          //var c1 = MDuration(MDuration.length-i+1).toInt
          var a1 = MDuration(i).toInt
          println("Duration is " + a1)
          
          //var b = Modes(Modes.length-i)
          var b = Modes(i-1)
          println("Modes " + b)
          //var b1 = MDuration(MDuration.length-i).toInt
          var b1 = MDuration(i-1).toInt
          println("Duration is " + b1)
          
          var c = Modes(i-2)
          //var a = Modes(Modes.length-i-1)
          println("Modes " + c)
          //var a1 = MDuration(i+2)
          var c1 = MDuration(i-2).toInt
          //var a1 = MDuration(MDuration.length-i-1).toInt
          println("Duration is " + c1)
         
          
          
        if( a1 >= b1 && a1 >= c1){
           println("1st Greater a1 " +a1)
          maxD=a1
         }
        
        else if(b1>=a1 && b1>=c1){ 
          println("2nd Greater b1 " + b1)
          maxD=b1
        }
        else if (c1>=b1 && c1>=a1)  {
          println("3rd Greater c1 " +c1)
          maxD=c1
        }
         println()
         
       var mH1  = maxD - a1 + 1
       var mH2  = maxD - b1 + 1
       var mH3  = maxD - c1 + 1
       
       Mheuristic = Mheuristic ++ Array(mH1)++ Array(mH2)++ Array(mH3)
       for (x <- Mheuristic){
         println(x)
       }
     }
     
      for (j<- MActivities.length-2 to 1 by -3 ){
          
          var current = MActivities(j)
          println("Current Activity" + current)
          
          var a = Modes(j).toInt
          println("Modes " + a)
          
          var a1 = MDuration(j).toInt
          println("Duration is " + a1)
          
          var are1 = r1(j).toInt
          println("re1 is " + are1)
          
          var are11 = r2(j).toInt
          println("re11 is " + are11)
          
          var ane1 = n1(j).toInt
          println("ne1 is " + ane1)
          
          var ane11 = n2(j).toInt
          println("ne11 is " + ane11)
          
          
          
           
           Mp1 = Math.pow(Mpheromone(Mpheromone.length-j), alpha)
           println("Pheromone value")
           print(" "+ Mp1)
           println()
          
           Mh1 = Math.pow(Mheuristic(Mheuristic.length-j), beta)
           println("Heuristic value")
           print(" "+ Mh1)
           println()
             
           Mprod1 = Mp1 * Mh1
           println("1st Mode's product of pheromone and heuristic is")
           print(" " + Mprod1)
           println()
          
           var b = Modes(j-1).toInt
           println("Modes " + b)
          
           var b1 = MDuration(j-1).toInt
           println("Duration is " + b1)
          
           var bre1 = r1(j-1).toInt
           println("re1 is " + bre1)
          
           var bre11 = r2(j-1).toInt
           println("re11 is " + bre11)
          
           var bne1 = n1(j-1).toInt
           println("ne1 is " + bne1)
          
           var bne11 = n2(j-1).toInt
           println("ne11 is " + bne11)
          
           Mp2 = Math.pow(Mpheromone(Mpheromone.length-j+1), alpha)
           println("Pheromone value")
           print(" "+ Mp2)
           println()
          
           Mh2 = Math.pow(Mheuristic(Mheuristic.length-j+1), beta)
           println("Heuristic value")
           print(" "+ Mh2)
           println()
             
           Mprod2 = Mp2 * Mh2
           println("2nd Mode's product of pheromone and heuristic is")
           print(" " + Mprod2)
           println()
          
           var c = Modes(j-2).toInt
           println("Modes " + c)
           var c1 = MDuration(j-2).toInt
           println("Duration is " + c1)
          
           var cre1 = r1(j-2).toInt
           println("re1 is " + cre1)
          
           var cre11 = r2(j-2).toInt
           println("re11 is " + cre11)
          
           var cne1 = n1(j-2).toInt
           println("ne1 is " + cne1)
          
           var cne11 = n2(j-2).toInt
           println("ne11 is " + cne11)
           
           Mp3 = Math.pow(Mpheromone(Mpheromone.length-j+2), alpha)
           println("Pheromone value")
           print(" "+ Mp3)
           println()
          
           Mh3 = Math.pow(Mheuristic(Mheuristic.length-j+2), beta)
           println("Heuristic value")
           print(" "+ Mh3)
           println()
             
           Mprod3 = Mp3 * Mh3
           println("3rd Mode's product of pheromone and heuristic is")
           print(" " + Mprod3)
           println()
           
           Msum = Mprod1 + Mprod2 + Mprod3
          
           Mprob1 = Mprod1 / Msum
           Mprob2 = Mprod2 / Msum
           Mprob3 = Mprod3 / Msum
          
           println("probability 1 " +Mprob1)
           println("probability 2 " +Mprob2)
           println("probability 3 " +Mprob3)
          
         
           if( Mprob1 >= Mprob2 && Mprob1 >= Mprob3){
           println("1st Greater Mode Probability " +Mprob1)
           maxP=Mprob1
             Sm = a
             Sd = a1
             Sre1  = are1 
             Sre11 = are11
             Sne1  = ane1
             Sne11 = ane11
         }
          if( Mprob2 >= Mprob1 && Mprob2 >= Mprob3){
           println("2nd Greater Mode Probability " +Mprob2)
           maxP=Mprob2
           Sm = b
           Sd = b1
          
           Sre1  = bre1 
           Sre11 = bre11
           Sne1  = bne1
           Sne11 = bne11
         }
          if( Mprob3 >= Mprob2 && Mprob3 >= Mprob1){
           println("3rd Greater Mode Probability " +Mprob3)
           maxP=Mprob3
           Sm = c
           Sd = c1
            
            Sre1  = cre1 
            Sre11 = cre11
            Sne1  = cne1
            Sne11 = cne11
         }
          Mprobability = Mprobability ++ Array(maxP)
          println("Mode Probability is")
          //var pp = Mprobability.zip (Stream from 1)
           for (pp <- Mprobability){
             println(pp)
           }
          
          SModes = SModes ++ Array(Sm)
          println("Selected Mode is")
           for (p <- SModes){
             println(p)
           } 
          
          Sduration = Sduration ++ Array(Sd)
          println("Selected duration is")
           for (p <- Sduration){
             println(p)
           } 
          
          Sr1 = Sr1 ++ Array(Sre1)
          println("Selected Rresouce1 is")
           for (p <- Sr1){
             println(p)
           } 
          
          Sr2 = Sr2 ++ Array(Sre11)
          println("Selected Rresouce2 is")
           for (p <- Sr2){
             println(p)
           } 
          
          Sn1 = Sn1 ++ Array(Sne1)
          println("Selected Nresouce1 is")
           for (p <- Sn1){
             println(p)
           } 
          
          Sn2 = Sn2 ++ Array(Sne11)
          println("Selected Nresouce2 is")
           for (p <- Sn2){
             println(p)
           } 
      }
      
      var Aseq =0
      
      for(i <- pp2.length-1  to 0 by -1 ){
       
        
        Aseq = pp2(i)
        println("Activity sequence is "+ Aseq)
        
        var Amode = SModes(Aseq-2)
        println("Activity Mode is "+ Amode)
        
        var Aduration = Sduration(Aseq-2)
        println("Activity duration is "+ Aduration)
        
        var selectR1 = Sr1(Aseq-2)
        println("Activity Rresouce1 is "+ selectR1)
        
        var selectR2 = Sr2(Aseq-2)
        println("Activity Rresouce2 is "+ selectR2)
        
        var selectN1 = Sn1(Aseq-2)
        println("Activity Nresouce1 is "+ selectN1)
        
        var selectN2 = Sn2(Aseq-2)
        println("Activity Nresouce2 is "+ selectN2)
        
        //var et1 = Aduration + st
        //println("Start Time is "+ et1)
        var pp1 = probability zip (Stream from 2)
        
        /*println("Probability is")
           for (p <- pp1){
             println(p)
           }*/
       
       println("Sorted Probability is")
       scala.util.Sorting.quickSort(pp1)
       
       /*for (p <- pp1){
            println(p)
       }*/
        
        println("only Probability is")
        var pp3 = pp1.map(x =>(x._1))
       for (p <- pp3){
            println(p)
       }
      //  lstFinal = lstFinal.updated(Activities.length-j-1, lst)
        STList = STList.updated(i, st)
        println("Start time list")
        for (p <- STList){
             println(p)
             } 
        
        
        if(sameProb == pp3(i) )
        {
          st=STList(i+1)
         // EndT = st + Aduration
          println("Satisfied ")
          
        }
        sameProb = pp3(i)
        println("Same Probability is "+ sameProb)
       
        EndT = st + Aduration
        EList = EList ++ Array(EndT) 
        println("End time list")
          for (p <- EList){
             println(p)
             } 
        
        st = EndT
        
        println("current Probability is "+ pp3(i)) 
       
      }
     
     
    //  var a = math.max(EndT, EndT)
    var max = EList.max
    println("project duration is "+max)
    println()
 
   //////////////////// Pheromone Updation for Activity///////////////////////////////////
    
   for (g <- pp2.length-1 to 0 by -1){
      var gAPh =0.0
     
     Aseq = pp2(g)
     println("Activity sequence is "+ Aseq)
     
     var GendTime = EList(pp2.length-g-1)
     println("Activity GendTime is "+ GendTime)
     if (GendTime == max){
       var gActD = EList.indexOf(max)
       println("index of max duration "+ gActD)
       gAPh = e * Q/max //global activity pheromone
       println("pheromone of max duration "+ gAPh)
     }
     
     
      AglobalPheromone = AglobalPheromone ++ Array(gAPh)
      /*println("globalllllll ")
      for (p <- AglobalPheromone){
             println(p)
             }*/
   }
      println("global pheromone values ")
      for (p <- AglobalPheromone){
             println(p)
             }
      var lAPh = 0.0
      var summation = 0.0
      var APhUpdate = 0.0
    
  for (l <- pp2.length-1 to 0 by -1){
      
       for(r <- 1 to e-1){
         
          println("checking end time "+EList(r))
          lAPh = ((e - r) * Q/ EList(r)) / max
          // AlocalPheromone = AlocalPheromone ++ Array(lAPh)
          summation = summation + lAPh
        }
       
           AlocalPheromone = AlocalPheromone ++ Array(summation) 
           println("final local pheromone values " )
              for (p <- AlocalPheromone){
                  println(p)
                   }
           // println("final local pheromone values " +summation )
  }
    
  for (i <- pp2.length-1 to 0 by -1){ 
      
         APhUpdate = (1-pEva) * pheromone(pp2.length-1-i) + AglobalPheromone(pp2.length-1-i) + AlocalPheromone(pp2.length-1-i)
         APhUpdation = APhUpdation ++ Array(APhUpdate) 
  }
         println("Activity pheromone updation ")
         for (p <- APhUpdation){
             println(p)
         }
    //////////////////// Pheromone Updation for Modes////////////////////////////////
 for(mg <- 0 to SModes.length-1  ){
        
          var gMh =0.0
          Aseq = pp2(mg)
          println("Activity sequence is "+ Aseq)
        
          var MGendTime = EList(SModes.length-mg-1)
          println("Mode GendTime is "+ MGendTime)
        
          if (MGendTime == max){
             
            var gMD = EList.indexOf(max)
             println("index of max duration "+ gMD)
             
             var Gmode = SModes(gMD)
             println("mode of max Activity's duration "+ Gmode)
             
             gMh = e * Q/max //global activity pheromone
             println("pheromone of max duration "+ gMh)
          }
        
          MglobalPheromone = MglobalPheromone ++ Array(gMh)
          println("globalllllll Modeee ")
     
          for (p <- MglobalPheromone){
              println(p)
          }
 }
    
    
         var lMh = 0.0
         var Msummation = 0.0
         var MPhUpdate = 0.0
    
 for(mg <- 0 to SModes.length-1  ){
       for(r <- 1 to e-1){
          
          println("checking end time "+EList(r))
          lMh = ((e - r) * Q/ EList(r))
          println("checking lmh "+lMh)
          // AlocalPheromone = AlocalPheromone ++ Array(lAPh)
          Msummation = Msummation + lMh
        }
          MlocalPheromone = MlocalPheromone ++ Array(Msummation) 
          println("final local pheromone values " )
          for (p <- MlocalPheromone){
             println(p)
             }
 }
    
for(mg <- 0 to SModes.length-1  ){
         
         MPhUpdate = (1-pEva) * Mpheromone(mg) + MglobalPheromone(mg) + MlocalPheromone(mg)
         MPhUpdation = MPhUpdation ++ Array(MPhUpdate) 
}
    
      println("Final updation ")
      for (p <- MPhUpdation){
           println(p)
           }
}
}
