public class Main {

    public static void main(String[] args) {
        Main main=new Main();
        int a[]={4,6,3,2,1,7,10};
//        main.insertSort(a);
//        main.bubbleSort(a);
//        main.selectSort(a);
        main.mergeSort(a,0,a.length-1);
        main.print(a);
    }

    public void print(int a[]){
        for(int i:a){
            System.out.print(i+" ");
        }
    }

    /**
     * 直插算法
     * @param a
     */
    public void  insertSort(int a[]){
        for(int i=1;i<a.length;i++)
        {
            int x=a[i];
            int j;
            for(j=i-1;j>=0;j--)
            {
                if(a[j]>x) a[j+1]=a[j];
                else {break;}
            }
            a[j+1]=x;
        }
        this.print(a);
    }

    /**
     * 冒泡排序
     * @param a
     */
    public void bubbleSort(int a[]){
        int i,j;
        for(i=0;i<a.length;i++)
        {
            for(j=0;j<a.length-i-1;j++)
            {
                if(a[j]<a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        this.print(a);
    }

    /**
     * 选择排序
     * @param a
     */
    public void selectSort(int a[]){
        if(a==null||a.length==0) return ;
        int i,j,min,minj;
        for(i=0;i<a.length;i++)
        {
            min=a[i];
            minj=i;
            for(j=i+1;j<a.length;j++)
            {
                if(a[j]<min){
                    minj=j;
                    min=a[j];
                }
            }
            int x=a[minj];
            a[minj]=a[i];
            a[i]=x;
        }
        this.print(a);
    }

    /**
     * 归并排序
     * @param a
     * @param l
     * @param h
     */
    public void mergeSort(int a[],int l,int h){
        if(a==null||a.length==0) return ;
        int mid=(l+h)/2;
        if(l<h){
            this.mergeSort(a,l,mid);
            this.mergeSort(a,mid+1,h);
            this.merge(a,l,mid,h);
        }
    }
    public void merge(int a[],int l,int mid,int h){
        int x1[]=new int[mid-l+2];
        int x2[]=new int[h-mid+2];
        for(int i=l;i<=mid+1;i++)
        {
            if(i!=mid+1) x1[i-l]=a[i];
            else x1[mid-l+1]=999999999;
        }
        for(int i=mid+1;i<=h+1;i++)
        {
            if(i!=h+1) x2[i-mid-1]=a[i];
            else x2[h-mid+1]=999999999;
        }
        int i=0,j=0,temp=l;
        while(temp<=h)
        {
            if(x1[i]<x2[j]){
                a[temp]=x1[i];
                i++;
            }else{
                a[temp]=x2[j];
                j++;
            }
            temp++;
        }
    }
}
