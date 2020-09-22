<template>
    <div class="sectrow">
        <div class="text">
            <span v-html="personText"></span>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        personText: {
            type: String,
            required: true,
        },
    },
};

import(
    /* webpackChunkName: "ProArtProfPersonText" */ "./v-style/_prof_person_text_default.scss"
);
import(
    /* webpackChunkName: "ProArtProfPersonText" */ "./v-style/_prof_person_text_media.scss"
);
</script>
