package we_won.hackerton.common.constant;

import we_won.hackerton.common.EnumModel;

public class EnumValue {
    private String key;
    private String value;

    public EnumValue(EnumModel enumModel) {
        key = enumModel.getKey();
        value = enumModel.getValue();
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
