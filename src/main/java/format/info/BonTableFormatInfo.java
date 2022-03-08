package format.info;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

/**
 * The information for tdmsg-kv formats.
 */
public class BonTableFormatInfo  {

    private static final long serialVersionUID = 1L;

    private static final String FIELD_FIELDS = "fields";
    private static final String FIELD_CHARSET = "charset";

    /**
     * The formats of fields.
     */
    @JsonProperty(FIELD_FIELDS)
    @NotEmpty
    private final List<BonFieldFormatInfo> fieldFormats;

    /**
     * The charset of the text.
     */
    @JsonProperty(FIELD_CHARSET)
    private final String charset;

    @JsonCreator
    public BonTableFormatInfo(
        @JsonProperty(FIELD_FIELDS)
            List<BonFieldFormatInfo> fieldFormats,
        @JsonProperty(FIELD_CHARSET)
            String charset,
        @JsonProperty(FIELD_IGNORE_ERRORS)
            Boolean ignoreErrors
    ) {
        super(ignoreErrors);

        this.fieldFormats = fieldFormats;
        this.charset = charset;
    }

    public List<BonFieldFormatInfo> getFieldFormats() {
        return fieldFormats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        BonTableFormatInfo that = (BonTableFormatInfo) o;
        return Objects.equals(fieldFormats, that.fieldFormats) &&
            Objects.equals(charset, that.charset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fieldFormats, charset);
    }

    @Override
    public String toString() {
        return "TDBonTableFormatInfo{" +
            "fieldFormats=" + fieldFormats +
            ", charset='" + charset + '\'' +
            ", ignoreErrors=" + ignoreErrors +
            '}';
    }
}
