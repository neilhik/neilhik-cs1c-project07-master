package hashTables;
import java.util.*;

public class FHhashQPwFind<KeyType, E extends Comparable<KeyType> >
        extends FHhashQP<E>
{
    protected E find(KeyType key) throws java.util.NoSuchElementException {
        int index = findPosKey(key);
        if(mArray[index].state == ACTIVE && mArray[index].data.equals(key))
            return mArray[index].data;
        throw new NoSuchElementException();
    }
    protected int myHashKey(KeyType key) {
        int hashVal;

        hashVal = key.hashCode() % mTableSize;
        if(hashVal < 0)
            hashVal += mTableSize;

        return hashVal;
    }
    protected int findPosKey(KeyType key) {

        int kthOddNum = 1;
        int index = myHashKey(key);

        while ( mArray[index].state != EMPTY
                && !mArray[index].data.equals(key) ) //.data??
        {
            index += kthOddNum; // k squared = (k-1) squared + kth odd #
            kthOddNum += 2; // compute next odd #
            if ( index >= mTableSize )
                index -= mTableSize;
        }
        return index;

    }
}
