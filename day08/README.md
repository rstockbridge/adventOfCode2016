# Day 8: Two-Factor Authentication

## Part 1

You come across a door implementing what you can only assume is an implementation of two-factor authentication after a long game of requirements telephone.

To get past the door, you first swipe a keycard (no problem; there was one on a nearby desk). Then, it displays a code on a little screen, and you type that code on a keypad. Then, presumably, the door unlocks.

Unfortunately, the screen has been smashed. After a few minutes, you've taken everything apart and figured out how it works. Now you just have to work out what the screen would have displayed.

The magnetic strip on the card you swiped encodes a series of instructions for the screen; these instructions are your puzzle input. The screen is 50 pixels wide and 6 pixels tall, all of which start off, and is capable of three somewhat peculiar operations:

- `rect AxB` turns on all of the pixels in a rectangle at the top-left of the screen which is `A` wide and `B` tall.
- `rotate row y=A` by `B` shifts all of the pixels in row `A` (`0` is the top row) right by `B` pixels. Pixels that would fall off the right end appear at the left end of the row.
- `rotate column x=A` by `B` shifts all of the pixels in column `A` (`0` is the left column) down by `B` pixels. Pixels that would fall off the bottom appear at the top of the column.

For example, here is a simple sequence on a smaller screen:

`rect 3x2` creates a small rectangle in the top-left corner:

    ###....
    ###....
    .......

`rotate column x=1 by 1` rotates the second column down by one pixel:

    #.#....
    ###....
    .#.....

`rotate row y=0 by 4` rotates the top row right by four pixels:

    ....#.#
    ###....
    .#.....

`rotate column x=1 by 1` again rotates the second column down by one pixel, causing the bottom pixel to wrap back to the top:

    .#..#.#
    #.#....
    .#.....

As you can see, this display technology is extremely powerful, and will soon dominate the tiny-code-displaying-screen market. That's what the advertisement on the back of the display tries to convince you, anyway.

There seems to be an intermediate check of the voltage used by the display: after you swipe your card, if the screen did work, how many pixels should be lit?

> Your puzzle answer was `121`.

## Part 2

You notice that the screen is only capable of displaying capital letters; in the font it uses, each letter is 5 pixels wide and 6 tall.

After you swipe your card, what code is the screen trying to display?

> Your puzzle answer was `RURUCEOEIL`.

# Running Java Solution

To run the solution for Day 8:

* From this directory using gradle: `./gradlew run`

* From `src/main/java`:
	1. Compile using `javac *.java`
	2. Run using `java Main`

# License

	MIT License

Copyright (c) 2017 Rebecca Stockbridge

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.