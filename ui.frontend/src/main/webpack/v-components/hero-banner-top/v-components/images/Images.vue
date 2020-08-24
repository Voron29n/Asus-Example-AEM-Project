<template>
    <div class="af-banner af-top-banner loaded" id="hero-banner-top">
        <ul class="top-slider slick-initialized slick-slider">
            <div class="slick-list draggable">
                <div class="slick-track" :style="fullWidth">
                    <li
                        class="slick-slide"
                        :class="
                                [index === activeImageId ? 'slick-current slick-active active-on' : 'active-off']
                                "
                        :style="widthLi"
                        v-for="(imageItem, index) in imagesData.heroItems"
                        :key="index"
                    >
                        <div class="banner-block af-top-banner" :title="imageItem.descriptionLink">
                            <div class="banner-inner">
                                <div class="banner-wrap">
                                    <a
                                        class="af-link-block"
                                        :title="imageItem.descriptionLink"
                                        :data-link="imageItem.linkTo"
                                        :href="imageItem.linkTo"
                                        :target="imageItem.linkUrlTarget"
                                    >{{ imageItem.descriptionLink }}
                                    </a>
                                    <div class="banner-img">
                                        <img
                                            :alt="imageItem.descriptionLink"
                                            :src="isDesktopVersion
                                                      ? imageItem.fileReferenceDesktop
                                                      : imageItem.fileReferenceMobile
                                                  "
                                        />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </div>
            </div>
            <v-slick-dots
                :items-data="imagesData.heroItems"
                :active-item-id="activeImageId"
                @change-slick-dots="slickDots"
            ></v-slick-dots>
            <v-slick-arrows
                :images-length="imagesLength"
                :active-image-id="activeImageId"
                @change-slick-arrow="slickNextOrPrev"
            ></v-slick-arrows>
        </ul>
    </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";
import SlickArrowsComponent from "@common/slick-arrow/SlickArrow";
import SlickDotsComponent from "@common/slick-dots/SlickDots";

export default {
    mixins: [adapt],
    components: {
        "v-slick-arrows": SlickArrowsComponent,
        "v-slick-dots": SlickDotsComponent,
    },
    props: {
        imagesData: Object,
    },
    data() {
        return {
            imagesLength: null,
            activeImageId: null,

            countForCycle: null,

            fullWidth: {
                width: null,
            },
            widthLi: {
                width: null,
            },
            pauseSlick: false,
        };
    },
    mounted() {
        this.imageLength();
        this.updateStyle();
        this.imageTimeout();
    },
    created() {
        window.addEventListener("resize", this.updateStyle);
    },
    methods: {
        activateImage(index) {
            this.activeImageId = index;
        },
        updateStyle() {
            this.updateFullWidth();
            this.updateStyleWidthLi();
            this.updateStyleLeftLi();
        },
        updateFullWidth() {
            this.fullWidth.width = this.imagesLength * window.innerWidth + "px";
        },
        updateStyleWidthLi() {
            this.widthLi.width = window.innerWidth + "px";
        },
        updateStyleLeftLi() {
            let elements = this.$el.querySelectorAll(
                ".top-slider .slick-slide"
            );
            elements.forEach(function (item, index) {
                if (index === 0) {
                    item.style.left = "0px";
                } else {
                    item.style.left = "-" + index * window.innerWidth + "px";
                }
            });
        },
        imageTimeout() {
            if (this.pauseSlick) {
                this.pauseSlick = false;
                setTimeout(this.imageTimeout, 10000);
            } else {
                this.activateImage(this.imagesLength - this.countForCycle);
                this.countForCycle--;
                if (this.countForCycle === 0)
                    this.countForCycle = this.imagesLength;
                setTimeout(this.imageTimeout, 5000);
            }
        },
        imageLength: function () {
            if (this.$props.imagesData.heroItems != null) {
                this.imagesLength = this.$props.imagesData.heroItems.length;
                this.countForCycle = this.imagesLength;
            }
        },
        slickNextOrPrev(selectIndex) {
            this.pauseSlick = true;
            this.activateImage(selectIndex);
        },
        slickDots(selectIndex) {
            this.pauseSlick = true;
            this.activateImage(selectIndex);
        },
    },
};
</script>

<style lang="scss">
@import "./images_default";
@import "./images_media";
</style>
