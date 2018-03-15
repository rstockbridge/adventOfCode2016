# Day 7: Internet Protocol Version 7

## Part 1

While snooping around the local network of EBHQ, you compile a list of IP addresses (they're IPv7, of course; IPv6 is much too limited). You'd like to figure out which IPs support TLS (transport-layer snooping).

An IP supports TLS if it has an Autonomous Bridge Bypass Annotation, or ABBA. An ABBA is any four-character sequence which consists of a pair of two different characters followed by the reverse of that pair, such as xyyx or abba. However, the IP also must not have an ABBA within any hypernet sequences, which are contained by square brackets.

For example:

- `abba[mnop]qrst` supports TLS (abba outside square brackets).
- `abcd[bddb]xyyx` does not support TLS (`bddb` is within square brackets, even though `xyyx` is outside square brackets).
- `aaaa[qwer]tyui` does not support TLS (`aaaa` is invalid; the interior characters must be different).
- `ioxxoj[asdfgh]zxcvbn` supports TLS (`oxxo` is outside square brackets, even though it's within a larger string).

How many IPs in your puzzle input support TLS?

> Your puzzle answer was `118`.

## Part 2

You would also like to know which IPs support SSL (super-secret listening).

An IP supports SSL if it has an Area-Broadcast Accessor, or ABA, anywhere in the supernet sequences (outside any square bracketed sections), and a corresponding Byte Allocation Block, or BAB, anywhere in the hypernet sequences. An ABA is any three-character sequence which consists of the same character twice with a different character between them, such as `xyx` or `aba`. A corresponding BAB is the same characters but in reversed positions: `yxy` and `bab`, respectively.

For example:

- `aba[bab]xyz` supports SSL (aba outside square brackets with corresponding bab within square brackets).
- `xyx[xyx]xyx` does not support SSL (`xyx`, but no corresponding `yxy`).
- `aaa[kek]eke` supports SSL (`eke` in supernet with corresponding `kek` in hypernet; the `aaa` sequence is not related, because the interior character must be different).
- `zazbz[bzb]cdb` supports SSL (`zaz` has no corresponding `aza`, but `zbz` has a corresponding `bzb`, even though `zaz` and `zbz` overlap).

How many IPs in your puzzle input support SSL?

> Your puzzle answer was `260`.

# Running Java Solution

To run the solution for Day 7:

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