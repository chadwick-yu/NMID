package bookstore;

public class Return implements Runnable {
    private Books b;

    Return(Books b) {
        this.b = b;
    }

    public int r = 10;
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag == true) {
            show();
            if (b.books_remain == b.books_sum) {
                //setFlag(false);
                System.out.println("Return当前图书馆库存已满，无需还书");
            }

            //if (Books.books_remain > 0) {
            //System.out.println("Return当前图书馆剩余书本库存为：" + Books.books_remain);
            //}
        }
    }

    private void show() {
        //用同一个传参锁进行代码同步化（因为是共享资源）
        synchronized (b) {
            //if(b.flag){
               // try{b.wait();}catch (Exception e){};
            //}
            if (b.books_remain < b.books_sum) {
                b.books_remain++;
                System.out.println("还书1本");
                System.out.println("Return当前图书馆库存为:" + b.books_remain);
            }
            //b.flag=true;
            //b.notify();//唤醒还书线程（input)
        }

    }
}


