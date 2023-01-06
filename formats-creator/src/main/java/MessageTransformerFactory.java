public class MessageTransformerFactory {

    public static MessageTransformer getMessageTransformer(FormatType formatType) {
        switch (formatType) {
            case JSON: {
                return new JSONTransformer();
            }
            case XML: {
                return new XMLTransformer();
            }
            default:
                //return null;
                throw new IllegalArgumentException("Wrong format type.");

        }
    }

}
