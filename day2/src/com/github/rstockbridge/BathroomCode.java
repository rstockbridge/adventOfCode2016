package com.github.rstockbridge;

public class BathroomCode {

    private static final String INSTRUCTIONS = "DULUDRDDDRLUDURUUULRRRURDRDULRUDDUDRULUDDUDRLDULRRLRDRUDUUULUUDLRURDU" +
            "DDDDRDLLLLULRDLDRDLRLULRUURDDUULUDLRURRDDRDDRDDLDRDLLUURDRUULRRURURRDLRLLLUDULULULULUDRLLRUDUURLDRLRLRDR" +
            "RDRLLLDURRDULDURDDRLURRDURLRRRLDLLLDRUUURLRDLDLLLLRDURRLDLULRLDDLDLURLRRDDRUDDUULRURRUDLRDLDUURDDDDRLRUR" +
            "UDULUDLRRLLLLLRDRURLLDLDULUUDLUDDDRLLDRRUDLLURRUUDDRRLLRRLDDDURLDRDRLURRRRDRRRDDUDULULDURRUUURRRDULUUUDD" +
            "RULDRLLRDLDURLURRLLRUUUULRDURLLDDRLLDLRLRULUUDRURUDLLURUDDRDURLRDRRRDURLDDRDRLRLLURULUUULUDDDULDLRDDDRDL" +
            "LRRLDRDULLUUUDLDDLDDDLLLLLLLDUDURURDURDRUURRRDDRDUDLULDURDUDURDDDRULDURURURRLURLURLUURLULDLLRUULURDDRLRD" +
            "DLRDLRRR\n" +
            "LUURLRUDRRUDLLDLUDDURULURLUUDUUDDRLUULRDUDDUULDUUDRURDDRRDRLULLRDRDLRLLUURRUULRLDRULUDLDUUDDDRDDLRDLULDR" +
            "LDUULDLRDLLLDLDLRDUULUDURRULLRLDUDRLLLULUUUULUUDUUURRRDULLUURUDRRLDURRUULDRDULDUDRDUUULUUDDRLUDRLDLDRUUU" +
            "RDLDUDRUDUURLLRRLRLLRRLDULDDULUDUUURULDDUDUDRURRDLULRUDDURDLDLLRRRLDRLULLLRUULDUDLUUDURRLLLRLUDURRDDLDRD" +
            "DDLURDLDRRUDUDLUDULULRUUUDLUURLLRLDDLURULDURDLRRDDDDURLDDLLDDULLLRLDLDULDUUDDRLDUURDDLDLUUDULRRLRLUURURU" +
            "URLRLURUURLDRUURLLRDDUUUDULUDDDRDRLDRDRRLRLDULLRRUDLURULULRDRURURLULDUDLRURLRDDRULDDLRD\n" +
            "LUDRULUULRRDDDDRRDUURUDDRLDDLDRDURRURULRDLDLDUUDRRDUUDUDLLLRRLDUDDRLDDLRRLRDRLUDLULUDDUUDULDUUULUDLDDURL" +
            "DURUDLDRUUDRLRRLDLDDULDUUDDLDDLLURDRLRUURDDRUDDUDLDRRLRUDRUULRRRLRULULURDLRRURDRLRULDDDRDUULLURUUUURUDDL" +
            "RRRRRDURLULDLUULUDRRUDUDRRDDRURDURLRLUDDLDLRRULUDLDDRLDDLDDDLLLLRDLLUULDDLULDLDRDDUDLURUDLDLDDRRUUDDDLRL" +
            "LLDRRDDDUURDUDURUURRDRLLDUDLDUULLDLDLLUULLRRULDLDRURLDULDRUURDURRURDLRDLLLDRRUDRUUDRURLUDDRURLDURRDLUUDL" +
            "UUDULLLDDDDRRDLLLDLURULDDRDLUUURRDRRUUDDUL\n" +
            "DUUULDUDDDURLLULDDLLUDURLLLURULULURUURDRURLRULLLLDRDDULRRDRRLLLRDDDUULLRRURRULLDDURRRLRDDLULDULLDUDLURRD" +
            "LDDLURDLRLLDRURLLRLLRRRDRRRURURUUDDLLDDLDDDLRLURUUUULRDLUDDDURLLDDRLDRRLLUDUUULRLLDRRRLRUUDLDUULRLUDRULL" +
            "LLDUDLLUUDDRUURLURUDRDDDLRURUDRLULLULUUDLDURDULRRDRLDURUULRDRRRDRDRRLRLRDDUULLRDLDURDDDULURRLULDDURDURDD" +
            "UDURDLLUUULUDULRDDLDRDRUDLLUURDLRDURURULURULLDRLLRRULDLULULDLULRURLRRLUDLLLRLUDLURLULDULDRLLLDLDDDDRDRLR" +
            "RLRDULUUDULDDLDURDLLLDDDDLLUURRDURLDLUDDLULRUUUDDRRLDLLLRDLLDRRRDDLULLURDDRRRRLDLRLLLRL\n" +
            "LULLRRDURRLDUUDRRURLURURRRLRDRUULUULURLLURRDRULRDURDDDDUULLLLDUULDLULURDRLDLULULDRLLDLLRLRULURUDRUUDULRU" +
            "LLLUDRULUDRLLUDLDRRDRUUURURLRDURDRLRDDDURLURRDLRUUUDUURULULDLUULRDLRRRDRDRLLLDLRRDRLLDDULDRUDRRLULLRDLDU" +
            "DDULRDDLULRURULRLLLULDLLLLRDLDRURUDUURURLDRLUULLDUDULUDDDULUDLRUDDUDLULLUULUUURULURRULRDDURDDLURLRRDRDLD" +
            "ULRLRDRRRULRDDDRLLDDDDRRRRDRDLULUURDURULDLRDULDUDLDURUDLUDLUDDDUDURDURDDURLLRUDUURRRUDRRRRULLLLDDDLUULLU" +
            "ULRRRULDLURDLULRULDRLR";

    public static void main(String[] args) {
        System.out.format("The Part I bathroom code is %s.\n", generateCodePartI());
        System.out.format("The Part II bathroom code is %s.\n", generateCodePartII());
    }

    private static String generateCodePartI() {
        final String[] instructions = INSTRUCTIONS.split("\n");
        KeypadCoordinates location = new KeypadCoordinates(0, 0);
        String code = "";

        char direction;
        for (String instruction : instructions) {
            for (int button = 0; button < instruction.length(); button++) {
                direction = instruction.charAt(button);

                if (direction == 'U') {
                    location.moveUpIfPossiblePartI();
                } else if (direction == 'D') {
                    location.moveDownIfPossiblePartI();
                } else if (direction == 'R') {
                    location.moveRightIfPossiblePartI();
                } else {
                    location.moveLeftIfPossiblePartI();
                }
            }

            code += location.getKeypadNumberPartI();
        }

        return code;
    }

    private static String generateCodePartII() {
        final String[] instructions = INSTRUCTIONS.split("\n");
        KeypadCoordinates location = new KeypadCoordinates(-2, 0);
        String code = "";

        char direction;
        for (String instruction : instructions) {
            for (int button = 0; button < instruction.length(); button++) {
                direction = instruction.charAt(button);

                if (direction == 'U') {
                    location.moveUpIfPossiblePartII();
                } else if (direction == 'D') {
                    location.moveDownIfPossiblePartII();
                } else if (direction == 'R') {
                    location.moveRightIfPossiblePartII();
                } else {
                    location.moveLeftIfPossiblePartII();
                }
            }

            code += location.getKeypadNumberPartII();
        }

        return code;
    }
}
