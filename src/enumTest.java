import java.util.EnumSet;

/**
 * @Description
 * @auther cnsrui
 * @create 2019-04-14 09:32
 */
public class enumTest {
    /**
     * Enum SeasonEnum
     */
    enum SeasonEnum {
        //
        SPRING(1),
        SUMMER(2),
        FALL(3),
        WINTER(4);

        private int valueEnum = 0;

        SeasonEnum(int valueEnum) {
            this.valueEnum = valueEnum;
        }

        public int getValueEnum() {
            return valueEnum;
        }
    }

    /**
     * 自定义 enum ，一定要写对应的构造函数
     */
    enum TypeEnum {
        //
        FIREWALL("firewall", 3),
        SECRET("secretMac", 4),
        BALANCE("f5", 5);

        private String typeName;
        private int num;

        TypeEnum(String typeName, int num) {
            this.typeName = typeName;
            this.num = num;
        }

        public String getTypeName() {
            return typeName;
        }

        public int getNum() {
            return num;
        }

        /**
         * 根据字符串，返回 TypeEnum 成员变量
         */
        public static TypeEnum fromTypeEnum(String typeName) {
            for (TypeEnum typeEnum : TypeEnum.values()) {
                if (typeEnum.getTypeName().equals(typeName)) {
                    return typeEnum;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        /** 以下为 Enum 实例*/
        /** 利用Enum对象的foreach方法结合Lambda表达式进行遍历*/
        EnumSet es = EnumSet.allOf(SeasonEnum.class);
        es.forEach(i -> System.out.print(i + " "));

        // enum值的数目
        System.out.println("enum的个数: " + SeasonEnum.values().length);
        // enum遍历
        for (SeasonEnum s : SeasonEnum.values()) {
            System.out.print(s.toString() + " ");
        }
        System.out.println();
        //int ordinal() 返回枚举常量的序数（它在枚举声明中的先后位置，其中最先的初始常量序数为零，其后+1）
        System.out.print(SeasonEnum.SPRING.ordinal());
        System.out.print(SeasonEnum.SUMMER.ordinal());
        System.out.print(SeasonEnum.FALL.ordinal());
        System.out.println(SeasonEnum.WINTER.ordinal());
        // 获取 Enum元素的值
        System.out.print(SeasonEnum.SPRING.getValueEnum());
        System.out.print(SeasonEnum.SUMMER.getValueEnum());
        System.out.print(SeasonEnum.FALL.getValueEnum());
        System.out.println(SeasonEnum.WINTER.getValueEnum());

        // 还可以利用其值进行计算
        System.out.println("Enum的计算： " + (SeasonEnum.WINTER.ordinal() - SeasonEnum.FALL.ordinal()));

        System.out.println("TYPE is length: " + TypeEnum.values().length);
        System.out.println(TypeEnum.FIREWALL.ordinal());
        System.out.println(TypeEnum.SECRET.ordinal());
        System.out.println(TypeEnum.BALANCE.ordinal());
        //像使用其他成员变量一样的使用 enum自定义的变量
        System.out.println(TypeEnum.BALANCE.getTypeName() + " " + TypeEnum.BALANCE.getNum());
        String strEnum = "secretMac";
        System.out.println(TypeEnum.fromTypeEnum(strEnum));

    }
}
