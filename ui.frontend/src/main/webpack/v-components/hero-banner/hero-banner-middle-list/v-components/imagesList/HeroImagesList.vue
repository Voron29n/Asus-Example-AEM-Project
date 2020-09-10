<template>
    <ul class="banner-hero-list">
        <div class="banner-hero-list-block">
            <div
                class="banner-hero-list-wrap"
                :style="componentStyle"
                @touchstart="startTouchMove"
                @touchmove="doTouchMove"
                @touchend="endTouchMove"
            >
                <li
                    class="banner-hero-list-item"
                    v-for="(heroMiddleItem, index) in heroBannerMiddleListData"
                    :key="heroMiddleItem.fileReferenceDesktop"
                    :class="{ active: index == activeImageId }"
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
            defaultStyleValue: {
                defaultTransition: "all 0.25s ease 0s",
            },
            componentStyle: {
                transform: "translateX(0px)",
                width: `${
                    document.body.clientWidth *
                    this.heroBannerMiddleListData.length
                }px`,
                transition: "all 0.25s ease 0s",
            },
            isNeedShowNextImg: false,
            timeoutData: {
                delayTime: 20000, // 5s
                timeoutObj: undefined,
            },
            touchMoveData: {
                startPositionX: 0,
                touchMoveX: 0,
                maxTouchMoveX: document.body.clientWidth * 0.1,
            },
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
            this.isNeedShowNextImg = true;
        },
        updateActiveImg() {
            if (this.isNeedShowNextImg) {
                let arrayLenght = this.heroBannerMiddleListData.length - 1;
                this.activeImageId =
                    this.activeImageId === arrayLenght
                        ? 0
                        : this.activeImageId + 1;
                this.updateComponentStyle();
            } else {
                this.isNeedShowNextImg = true;
            }
            this.timeoutData.timeoutObj = setTimeout(
                this.updateActiveImg,
                this.timeoutData.delayTime
            );
        },
        adaptToWindow() {
            this.isDesktopVersionMeth();
            this.updateComponentStyle();
        },
        updateComponentStyle() {
            this.componentStyle.transform = `translateX(${
                this.isDesktopVersion
                    ? 0
                    : -document.body.clientWidth * this.activeImageId
            }px)`;
            this.componentStyle.width = `${
                this.isDesktopVersion
                    ? document.body.clientWidth
                    : document.body.clientWidth *
                      this.heroBannerMiddleListData.length
            }px`;
        },
        startTouchMove(event) {
            event.preventDefault();
            this.componentStyle.transition = "none";
            clearTimeout(this.timeoutData.timeoutObj);

            this.touchMoveData.startPositionX = event.touches[0].clientX;
        },
        doTouchMove(event) {
            let touchPosititonX = event.touches[0].clientX;
            this.touchMoveData.touchMoveX =
                touchPosititonX - this.touchMoveData.startPositionX;
            this.componentStyle.transform = `translateX(${
                -document.body.clientWidth * this.activeImageId +
                this.touchMoveData.touchMoveX
            }px`;
        },
        endTouchMove() {
            if (
                Math.abs(this.touchMoveData.touchMoveX) > this.touchMoveData.maxTouchMoveX
            ) {
                let touchMoveImg = this.touchMoveData.touchMoveX / document.body.clientWidth;
                let countMoveImgId =
                    Math.abs(touchMoveImg) < 1
                        ? 1
                        : Math.ceil(Math.abs(touchMoveImg));
                let changeActivateId = this.activeImageId - Math.sign(touchMoveImg) * countMoveImgId;
                if (changeActivateId < 0) {
                    this.activeImageId = 0;
                } else {
                    let arrayLenght = this.heroBannerMiddleListData.length - 1;
                    this.activeImageId =
                        changeActivateId > arrayLenght
                            ? arrayLenght
                            : changeActivateId;
                }
            }
            this.updateComponentStyle();
            this.isNeedShowNextImg = false;
            this.componentStyle.transition = this.defaultStyleValue.defaultTransition;
            this.updateActiveImg();
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
@import "./banner_images_list_media";
</style>
