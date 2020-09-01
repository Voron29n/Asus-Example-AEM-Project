<template>
    <div class="af-banner-hero">
        <div class="banner-hero-image-block">
            <div class="banner-hero-image-inner">
                <div class="banner-hero-image-wrap">
                    <a
                        class="af-banner-hero-image-link-block"
                        :title="heroItem.descriptionLink"
                        :href="heroItem.linkTo"
                        :target="heroItem.linkUrlTarget"
                    ></a>
                    <div class="banner-hero-image-img">
                        <img
                            :src="isDesktopVersion ? heroItem.fileReferenceDesktop
                                               : heroItem.fileReferenceMobile"
                        />
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
    props: {
        heroItem: {
            type: Object,
            required: true,
        },
    },
};
</script>
<style lang="scss" scoped>
@import "./banner_middle_list_image_default";
// @import "./v-style/banner_middle_list_images_media";
</style>