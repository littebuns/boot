package personal.xxb.kakfa.stream.util;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@Slf4j
public class BeanUtil {

    /**
     * @param bytes 字节数组
     * @return Object Object对象
     * @Description 字节数组转对象
     */
    public static Object deserializeFromBytes(byte[] bytes) {
        Object obj = null;
        ByteArrayInputStream bi = null;
        ObjectInputStream oi = null;
        try {
            bi = new ByteArrayInputStream(bytes);
            oi = new ObjectInputStream(bi);
            obj = oi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bi != null) {
                    bi.close();
                }
                if (oi != null) {
                    oi.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage(),e);
            }
        }
        return obj;
    }

    /**
     * @param obj Object对象
     * @return byte[] 字节数组
     * @Description 对象转字节数组
     */
    public static byte[] serializeToBytes(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bo = null;
        ObjectOutputStream oo = null;
        try {
            bo = new ByteArrayOutputStream();
            oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            bytes = bo.toByteArray();

        } catch (IOException e) {
            log.error(e.getMessage(),e);
        } finally {
            try {
                if (bo != null) {
                    bo.close();
                }
                if (oo != null) {
                    oo.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage(),e);
            }
        }
        return bytes;
    }

}
