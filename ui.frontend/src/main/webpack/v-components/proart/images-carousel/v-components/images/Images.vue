<template>
    <div class="col l12 m12 s12">
        <div class="software-list">
            <div class="list-row"
                v-for="item in imagesData"
                :key="item.title"
                :style="[getStyleSpeed(item.speedMoveImage), getStyleWidthImage(item.currentWidthImage)]"
                >   
                <figure class="img list-img"
                :class="[ item.rightSideMove ? 'img-right' : 'img-left']"
                :style="{ 
                    backgroundImage: 'url('+item.fileReference+')',
                    }"
                ></figure>
                <figure class="img list-img"
                :class="[ item.rightSideMove ? 'img-right' : 'img-left']"
                :style="{ 
                    backgroundImage: 'url('+item.fileReference+')',
                    }"
                ></figure>
            </div>
        </div>
    </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
    props: {
        imagesData: {
            type: Array,
            required: false,
        },
    },
    methods: {
        getStyleSpeed(value) {
            return {
                "--speed-row": value + 'ms',
            }
        },
        getStyleWidthImage(value) {
            return {
               "--img-orig-width": value + 'px', 
               "--img-width": this.isDesktopVersion ?  value + 'px' : value*0.697 + 'px',
               "--img-left": this.isDesktopVersion ?  '-'+ value + 'px' : '-'+ value*0.697 + 'px',
            }
        },
    }
};
</script>
<style lang="scss" scoped>
@import "./images_default";
@import "./images_media";
</style>