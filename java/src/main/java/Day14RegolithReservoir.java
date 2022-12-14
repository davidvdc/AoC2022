import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.*;
import io.vavr.control.Option;

import java.util.function.Function;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Day14RegolithReservoir {

    public static void main(String[] args) {
        String testInput = "498,4 -> 498,6 -> 496,6\n" +
                "503,4 -> 502,4 -> 502,9 -> 494,9";
        Day14RegolithReservoir day14 = new Day14RegolithReservoir();
        day14.dropSand(testInput);

        String mainInput = "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "568,139 -> 573,139\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "517,81 -> 517,84 -> 509,84 -> 509,92 -> 524,92 -> 524,84 -> 522,84 -> 522,81\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "531,98 -> 531,102 -> 526,102 -> 526,109 -> 540,109 -> 540,102 -> 535,102 -> 535,98\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "534,78 -> 539,78\n" +
                "513,78 -> 518,78\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "531,98 -> 531,102 -> 526,102 -> 526,109 -> 540,109 -> 540,102 -> 535,102 -> 535,98\n" +
                "553,133 -> 558,133\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "511,53 -> 515,53\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "543,144 -> 543,145 -> 560,145 -> 560,144\n" +
                "522,69 -> 527,69\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "560,133 -> 565,133\n" +
                "561,139 -> 566,139\n" +
                "518,94 -> 518,95 -> 532,95 -> 532,94\n" +
                "497,13 -> 497,17 -> 489,17 -> 489,22 -> 502,22 -> 502,17 -> 501,17 -> 501,13\n" +
                "531,98 -> 531,102 -> 526,102 -> 526,109 -> 540,109 -> 540,102 -> 535,102 -> 535,98\n" +
                "553,118 -> 553,120 -> 549,120 -> 549,124 -> 561,124 -> 561,120 -> 557,120 -> 557,118\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "517,53 -> 521,53\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "518,94 -> 518,95 -> 532,95 -> 532,94\n" +
                "520,78 -> 525,78\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "546,114 -> 546,115 -> 554,115 -> 554,114\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "522,63 -> 527,63\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "564,136 -> 569,136\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "534,111 -> 534,112 -> 549,112 -> 549,111\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "497,13 -> 497,17 -> 489,17 -> 489,22 -> 502,22 -> 502,17 -> 501,17 -> 501,13\n" +
                "553,118 -> 553,120 -> 549,120 -> 549,124 -> 561,124 -> 561,120 -> 557,120 -> 557,118\n" +
                "526,72 -> 531,72\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "533,66 -> 538,66\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "527,78 -> 532,78\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "517,81 -> 517,84 -> 509,84 -> 509,92 -> 524,92 -> 524,84 -> 522,84 -> 522,81\n" +
                "517,81 -> 517,84 -> 509,84 -> 509,92 -> 524,92 -> 524,84 -> 522,84 -> 522,81\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "553,118 -> 553,120 -> 549,120 -> 549,124 -> 561,124 -> 561,120 -> 557,120 -> 557,118\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "497,13 -> 497,17 -> 489,17 -> 489,22 -> 502,22 -> 502,17 -> 501,17 -> 501,13\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "550,136 -> 555,136\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "556,130 -> 561,130\n" +
                "517,81 -> 517,84 -> 509,84 -> 509,92 -> 524,92 -> 524,84 -> 522,84 -> 522,81\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "547,139 -> 552,139\n" +
                "505,57 -> 509,57\n" +
                "497,13 -> 497,17 -> 489,17 -> 489,22 -> 502,22 -> 502,17 -> 501,17 -> 501,13\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "567,133 -> 572,133\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "520,55 -> 524,55\n" +
                "517,81 -> 517,84 -> 509,84 -> 509,92 -> 524,92 -> 524,84 -> 522,84 -> 522,81\n" +
                "543,144 -> 543,145 -> 560,145 -> 560,144\n" +
                "553,118 -> 553,120 -> 549,120 -> 549,124 -> 561,124 -> 561,120 -> 557,120 -> 557,118\n" +
                "497,13 -> 497,17 -> 489,17 -> 489,22 -> 502,22 -> 502,17 -> 501,17 -> 501,13\n" +
                "575,139 -> 580,139\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "511,57 -> 515,57\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "497,13 -> 497,17 -> 489,17 -> 489,22 -> 502,22 -> 502,17 -> 501,17 -> 501,13\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "517,81 -> 517,84 -> 509,84 -> 509,92 -> 524,92 -> 524,84 -> 522,84 -> 522,81\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "553,118 -> 553,120 -> 549,120 -> 549,124 -> 561,124 -> 561,120 -> 557,120 -> 557,118\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "531,98 -> 531,102 -> 526,102 -> 526,109 -> 540,109 -> 540,102 -> 535,102 -> 535,98\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "514,55 -> 518,55\n" +
                "546,114 -> 546,115 -> 554,115 -> 554,114\n" +
                "557,136 -> 562,136\n" +
                "571,136 -> 576,136\n" +
                "546,114 -> 546,115 -> 554,115 -> 554,114\n" +
                "497,13 -> 497,17 -> 489,17 -> 489,22 -> 502,22 -> 502,17 -> 501,17 -> 501,13\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "553,118 -> 553,120 -> 549,120 -> 549,124 -> 561,124 -> 561,120 -> 557,120 -> 557,118\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "525,60 -> 530,60\n" +
                "559,127 -> 564,127\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "517,81 -> 517,84 -> 509,84 -> 509,92 -> 524,92 -> 524,84 -> 522,84 -> 522,81\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "529,63 -> 534,63\n" +
                "526,66 -> 531,66\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "508,55 -> 512,55\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "534,111 -> 534,112 -> 549,112 -> 549,111\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "531,98 -> 531,102 -> 526,102 -> 526,109 -> 540,109 -> 540,102 -> 535,102 -> 535,98\n" +
                "516,75 -> 521,75\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "523,75 -> 528,75\n" +
                "523,57 -> 527,57\n" +
                "519,66 -> 524,66\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "554,139 -> 559,139\n" +
                "543,144 -> 543,145 -> 560,145 -> 560,144\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "553,118 -> 553,120 -> 549,120 -> 549,124 -> 561,124 -> 561,120 -> 557,120 -> 557,118\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "514,51 -> 518,51\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "517,57 -> 521,57\n" +
                "531,98 -> 531,102 -> 526,102 -> 526,109 -> 540,109 -> 540,102 -> 535,102 -> 535,98\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "518,94 -> 518,95 -> 532,95 -> 532,94\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "496,35 -> 496,29 -> 496,35 -> 498,35 -> 498,26 -> 498,35 -> 500,35 -> 500,25 -> 500,35 -> 502,35 -> 502,34 -> 502,35 -> 504,35 -> 504,31 -> 504,35 -> 506,35 -> 506,33 -> 506,35 -> 508,35 -> 508,25 -> 508,35\n" +
                "530,75 -> 535,75\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "519,72 -> 524,72\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "563,130 -> 568,130\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "531,98 -> 531,102 -> 526,102 -> 526,109 -> 540,109 -> 540,102 -> 535,102 -> 535,98\n" +
                "534,111 -> 534,112 -> 549,112 -> 549,111\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "561,171 -> 561,162 -> 561,171 -> 563,171 -> 563,168 -> 563,171 -> 565,171 -> 565,163 -> 565,171 -> 567,171 -> 567,163 -> 567,171 -> 569,171 -> 569,161 -> 569,171 -> 571,171 -> 571,170 -> 571,171 -> 573,171 -> 573,166 -> 573,171 -> 575,171 -> 575,161 -> 575,171 -> 577,171 -> 577,165 -> 577,171\n" +
                "501,48 -> 501,44 -> 501,48 -> 503,48 -> 503,39 -> 503,48 -> 505,48 -> 505,39 -> 505,48 -> 507,48 -> 507,41 -> 507,48 -> 509,48 -> 509,41 -> 509,48 -> 511,48 -> 511,47 -> 511,48 -> 513,48 -> 513,47 -> 513,48 -> 515,48 -> 515,43 -> 515,48\n" +
                "551,158 -> 551,154 -> 551,158 -> 553,158 -> 553,156 -> 553,158 -> 555,158 -> 555,152 -> 555,158 -> 557,158 -> 557,149 -> 557,158 -> 559,158 -> 559,156 -> 559,158 -> 561,158 -> 561,152 -> 561,158 -> 563,158 -> 563,155 -> 563,158 -> 565,158 -> 565,153 -> 565,158 -> 567,158 -> 567,155 -> 567,158 -> 569,158 -> 569,149 -> 569,158\n";
        day14.dropSand(mainInput);

    }

    record Point(int x, int y) {
        Point(String point) {
            this(point.split(","));
        }

        Point(String[] point) {
            this(Integer.parseInt(point[0]), Integer.parseInt(point[1]));
        }

        public Stream<Point> lineTo(Point point) {
            return Stream.rangeClosed(min(this.x, point.x), max(this.x, point.x))
                    .flatMap(xval -> Stream.rangeClosed(min(this.y, point.y), max(this.y, point.y)).map(yval -> new Point(xval, yval)));
        }

        public Point down() {
            return new Point(x, y + 1);
        }

        public Point downLeft() {
            return new Point(x - 1, y + 1);
        }

        public Point downRight() {
            return new Point(x + 1, y + 1);
        }
    }

    private void dropSand(String input) {
        Stream<String> lines = Stream.ofAll(input.lines());
        Map<Point, String> points = createCave(lines);

        printCave(points);

        countSandDropsFrom(points, 500, 0);
    }

    private void countSandDropsFrom(Map<Point, String> points, int x, int y) {
        Point startPoint = new Point(x, y);
        int floor = points.keySet().map(k -> k.y).max().get() + 2;
        Tuple2<Map<Point, String>, Integer> sandCount = Stream.continually(0)
                .scanLeft(points, (pts, ignored) -> {
                    Point last = dropSandFrom(pts, x, y, floor).last();
                    return pts.put(last, "o");
                })
                .zipWithIndex()
                .peek(t -> {
                    if (t._2 % 100 == 0) {
                        printCave(t._1);
                    }
                })
                .takeWhile(t -> !t._1.containsKey(startPoint)).last();


        printCave(sandCount._1);

        System.out.println(sandCount._2());


    }

    private static Stream<Point> dropSandFrom(Map<Point, String> points, int x, int y, int floor) {
        return Stream.unfoldRight(new Point(x, y), p -> {
                    if (!points.containsKey(p.down())) {
                        Point down = p.down();
                        return Option.some(Tuple.of(down, down));
                    } else if (!points.containsKey(p.downLeft())) {
                        Point downLeft = p.downLeft();
                        return Option.some(Tuple.of(downLeft, downLeft));
                    } else if (!points.containsKey(p.downRight())) {
                        Point downRight = p.downRight();
                        return Option.some(Tuple.of(downRight, downRight));
                    } else {
                        return Option.none();
                    }
                }).prepend(new Point(x,y))
                .takeWhile(p -> p.y < floor);
    }

    private static Map<Point, String> createCave(Stream<String> lines) {
        Map<Point, String> points = lines
                .flatMap(line ->
                        {
                            List<Point> linePoints = List.of(line.split("->"))
                                    .map(String::trim)
                                    .map(Point::new);
                            List<List<Point>> pointToPoint = linePoints
                                    .sliding(2, 1).toList();
                            return pointToPoint
                                    .flatMap(pointPair -> pointPair.get(0).lineTo(pointPair.get(1)));
                        }
                )
                .toMap(Function.identity(), x -> "#");
        return points;
    }

    private static void printCave(Map<Point, String> points) {
        System.out.println();
        int minx = points.keySet().map(k -> k.x).min().get();
        int maxx = points.keySet().map(k -> k.x).max().get();
        int maxy = points.keySet().map(k -> k.y).max().get();

        for (int i = 0; i < 3; i++) {
            System.out.print("  ");
            for (int j = minx - 5; j <= maxx + 5; j++) {
                if (j % 2 == 0) {
                    System.out.print(String.valueOf(j).charAt(i));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int y = 0; y <= maxy; y++) {
            System.out.print(y + " ");
            for (int j = minx - 5; j <= maxx + 5; j++) {
                System.out.print(points.get(new Point(j, y)).getOrElse("."));
            }
            System.out.println();
        }
    }
}
