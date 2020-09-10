<template>
    <ul class="banner-hero-list">
        <div class="banner-hero-list-block">
            <div class="banner-hero-list-wrap" :style="componentStyle">
                <li
                    class="banner-hero-list-item"
                    v-for="(heroMiddleItem, index) in heroBannerMiddleListData"
                    :key="heroMiddleItem.fileReferenceDesktop"
                    :class="{'active': index == activeImageId }"
                >
                    <VueHeroImg :hero-item="heroMiddleItem"></VueHeroImg>
                </li>
            </div>
        </div>
        <VueSlickDots
            v-if="isNeedShowSlickDots"
            :items-data="heroBannerMiddleListData"
            :active-item-id="activeImageId"
            @change-slick-dots="slickDots"
        ></VueSlickDots>
    </ul>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
    components: {
        VueHeroImg: () =>
            import(
                /* webpackChunkName: "HeroBannerMiddleList" */ "../heroImage/HeroMiddleListImage"
            ),
        VueSlickDots: () =>
            import(
                /* webpackChunkName: "SlickDots" */ "@common/slick-dots/SlickDots"
            ),
    },
    props: {
        heroBannerMiddleListData: {
            type: Array,
            required: true,
        },
    },
    data() {
        return {
            activeImageId: 0,
            componentStyle: {
                transform: "translate3d(0px, 0px,0px)",
                width: `${
                    window.innerWidth * this.heroBannerMiddleListData.length
                }px`,
            },
            isSlickDotsPressed: false,
            delayTime: 5000, // 5s
        };
    },
    mounted() {
        this.adaptToWindow();
        this.updateActiveImg();
    },
    methods: {
        slickDots(selectIndex) {
            this.activeImageId = selectIndex;
            this.updateComponentStyle();
            this.isSlickDotsPressed = true;
        },
        updateActiveImg() {
            if (this.isSlickDotsPressed) {
                this.isSlickDotsPressed = false;
            } else {
                let arrayLenght = this.heroBannerMiddleListData.length - 1;
                this.activeImageId =
                    this.activeImageId === arrayLenght
                        ? 0
                        : this.activeImageId + 1;
                this.updateComponentStyle();
            }
            setTimeout(this.updateActiveImg, 5000);
        },
        adaptToWindow() {
            this.isDesktopVersionMeth();
            this.updateComponentStyle();
        },
        updateComponentStyle() {
            this.componentStyle.transform = `translate3d(${
                this.isDesktopVersion
                    ? 0
                    : -window.innerWidth * this.activeImageId
            }px, 0px,0px)`;
            this.componentStyle.width = `${
                this.isDesktopVersion
                    ? window.innerWidth
                    : window.innerWidth * this.heroBannerMiddleListData.length
            }px`;
        },
    },
    computed: {
        isNeedShowSlickDots() {
            return (
                !this.isDesktopVersion &&
                this.heroBannerMiddleListData.length > 1
            );
        },
    },
};
</script>
<style lang="scss" scoped>
@import "./banner_images_list_default";
</style>