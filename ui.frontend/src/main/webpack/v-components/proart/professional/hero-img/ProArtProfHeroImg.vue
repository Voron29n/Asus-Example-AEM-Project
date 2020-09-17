<template>
    <div class="prof-hero-img">
        <div class="prof-hero-img-inner">
            <img
                :src="fileReference"
            />
        </div>
    </div>
</template>

<script>
export default {
    props: {
        fileReference: {
            type: String,
            required: false,
        },
    },
};

import(
    /* webpackChunkName: "ProArtProfHeroImg" */ "./v-style/_prof_hero_img_default.scss"
);
import(
    /* webpackChunkName: "ProArtProfHeroImg" */ "./v-style/_prof_hero_img_media.scss"
);
</script>
