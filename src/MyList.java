public class MyList <T> {

    public  T[] genericArray;

    public T[] getGenericArray() {
        return genericArray;
    }

    public void setGenericArray(T[] genericArray) {
        this.genericArray = genericArray;
    }

    public MyList(){
            setGenericArray((T[]) new Object[10]);
        }

    public MyList(int capacity){
        setGenericArray((T[]) new Object[capacity]);
    }


    public boolean set(int index, T data){
        if(index >= 0){

            if(index <= getCapacity()-1){
                getGenericArray()[index] = data;

                return  true;
            }
            else{
                System.out.println("HATA : Belirtilen index (" + index + ") dizi sınırlarının dışındadır.");
                return false;
            }

        }
        else{
            System.out.println("HATA : setElement metoduna negatyif değer girilmemelidir.");
            return false;
        }
    }


    public boolean remove(int index){

        if(index >=0){
            if(index <= getCapacity()-1){
                for(int i = index;i<getCapacity()-1;i++){
                    getGenericArray()[i] = getGenericArray()[i+1];
                }
                getGenericArray()[getCapacity()-1] = null;
                return true;


            }

            else {
                System.out.println("HATA : Belirtilen index("+index+") dizi sınırları dışındadır.");
                return false;
            }



        }
        else{
            //Bu noktada gönderilen parametre negatif değere sahip demektir. Geriye null döndürüp, console'a hata yazdır.
            System.out.println("HATA : getElement metoduna negatif değer girilmemelidir.");
            return false; //İşlem başarısız geriye false döndürüyoruz.

        }
    }

    public T get(int index){
        if(index >= 0){
            if(index <= getCapacity()-1){
                return getGenericArray()[index];
            }
            else {
                System.out.println("HATA : Belirtilen index("+index+") dizi sınırları dışındadır.");
                return null;
            }

        }
        else{
            System.out.println("HATA : getElement metoduna negatif değer girilmemelidir.");
            return null;
        }
    }

    public int indexOf(T data){

        for(int i = 0; i < getCapacity(); i++){
            if(get(i)== data){
                return i;
            }
        }

        return -1;

    }
    public int lastIndexOf(T data){
        int lastIndex=-1;

        for(int i = 0;i<getCapacity();i++){
            if(get(i)==data){
                lastIndex=i;
            }
        }


        return lastIndex;
    }
    public void add(T element){
        checkCapacity(1);



        getGenericArray()[size()]=element;

    }

    public void addMultipleElement(T... elements){

        checkCapacity(elements.length);

        for (T element:
                elements) {
            int elementNumber = 0;
            getGenericArray()[size()+elementNumber++] = element;

        }
    }

    public void checkCapacity(int elementCount){
        if(!(elementCount<=getAvailableCapacity())){

            this.doubleCapacity();
            this.checkCapacity(elementCount);
        }

    }

    public int size(){
        int elementCounter = 0;

        for(int i=0;i<getCapacity();i++)
        {
            if(getGenericArray()[i]!=null){
                elementCounter++;
            }

        }
        return elementCounter;
    }

    public boolean isEmpty(){

        if(size()>0){

            return false;
        }
        else{

            return true;
        }

    }

    public int getCapacity(){
        return getGenericArray().length;
    }

    public int getAvailableCapacity(){
        return getCapacity()- size();
    }

    public void doubleCapacity(){
        T[] temporaryArray = getGenericArray();

        setGenericArray((T[]) new Object[getCapacity()*2]);

        int i = 0;
        for (T oldElements:
                temporaryArray) {
            this.genericArray[i++]=oldElements;
        }
    }

    public T[] toArray(){
        T[] newArray = (T[]) new Object[size()];

        for(int i = 0;i<size();i++){
            newArray[i] = get(i);
        }
        return newArray;
    }

    public void clear(){
        setGenericArray((T[]) new Object[10]);

    }

    public MyList<T> subList(int start, int finish){


        if(start>=0 && finish>=0){


            if((start<this.getCapacity())&&(finish<this.getCapacity())){


                int newListElementCount = (finish-start)+1;



                MyList<T> newList = new MyList<>(newListElementCount);
                for(int i=start;i<=finish;i++){
                    newList.add(get(i));
                }

                return newList;

            }
            else {

                System.out.println("HATA : Parametrelerin dizinin sınırlarından büyük olmaması gerekiyor.");
                return null;

            }

        }
        else{

            System.out.println("HATA : Parametrelerin 0 ve daha yüksek değerlere sahip olması gerekmektedir.");
            return null;
        }
    }


    public boolean contains(T data){

        for(int i =0;i<getCapacity();i++){
            if(get(i)==data){

                return true;

            }
        }
        return false;


    }



}
