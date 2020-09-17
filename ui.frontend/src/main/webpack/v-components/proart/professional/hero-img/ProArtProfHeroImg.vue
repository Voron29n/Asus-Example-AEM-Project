<template>
    <div>
        ProArtProfHeroImg with param - {{fileReference}}
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

import (/* webpackChunkName: "ProArtProfHeroImg" */ './v-style/_prof_hero_img_default.scss');
import (/* webpackChunkName: "ProArtProfHeroImg" */ './v-style/_prof_hero_img_media.scss');
</script>
