<template>
    <div class="banner-small-wrap">
        <a
            class="af-banner-small-link-block"
            :href="heroSmallData.heroLink.linkTo"
            :target="heroSmallData.heroLink.linkUrlTarget"
        ></a>
        <div class="banner-small-img">
            <img :src="heroSmallData.fileReference" />
        </div>
        <div class="banner-small-info">
            <div :class="{'banner-small-info-wrap' : !isDesktopVersion}">
                <div class="banner-small-title">{{heroSmallData.heroTitle}}</div>
                <h3 class="banner-small-sub-title">{{heroSmallData.heroDescription}}</h3>
            </div>
        </div>
    </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
    props: {
        heroSmallData: Object,
    },
};
</script>

<style lang="scss">
@import "./hero_small_default";
@import "./hero_small_media";
</style>