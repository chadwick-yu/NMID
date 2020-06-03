package bookstore;

public class Get implements Runnable {
    private Books b;

    Get(Books b) {
        this.b = b;
    }

    public int r1 = 10;
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    @Override
    public void run() {
        while (flag == true) {
            show();
            //if(Books.books_remain>0) {
            // System.out.println("当前图书馆剩余库存为" + Books.books_remain);
            //}

        }

    }


    private void show() {
        //用同一个传参锁进行代码同步化
        synchronized (b) {
            if(b.books_remain==0){
                b.flag=true;
                try{wait();}catch (Exception e){};
            }
            //if (b.books_remain == 0) {
              //  b.flag = false;
            //}
            ///if (!b.flag) {
            /// try {
            ///    b.wait();
            ///} catch (Exception e) {
            ///}
            ;
        //}
                if (b.books_remain > 0) {
                    b.books_remain--;
                    System.out.println("借书一本");
                    System.out.println("当前图书馆库存为:" + b.books_remain);
                }
                if(b.books_remain==b.books_sum) {
                    b.flag = false;//
                    b.notify();//唤醒借书线程（output）
                }
            }
        }
    }
